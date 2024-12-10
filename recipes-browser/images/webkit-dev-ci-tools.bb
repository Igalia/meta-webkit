SUMMARY = "Image with all the required tools to build WPE (using the script build-webkit) \
           and also run the tests (layout-tests, performance-tests, api-tests, etc). \
           The SDK that gets build with 'bitbake ${IMAGENAME} -c populate_sdk' is valid \
           for using in the host with the script build-webkit and the image itself has \
           the tools to run the tests on the board. But the image doesn't contain \
           webkit (wpe) itself. The purpose of this image is for using on the \
           continous integration systems of webkit.org for WPE tests. \
           For more info see the WebKit script named cross-toolchain-helper."

LICENSE = "MIT"

# Default values that can be overriden by the user are set before including
# anything so they take precedence as default value.
# Note: xz -0 compresses better and faster than bzip2 with default values.
XZ_COMPRESSION_LEVEL ?= "-0"
SDK_XZ_COMPRESSION_LEVEL ?= "-0"

# Use .xz instead of .bz2
IMAGE_FSTYPES:append = " tar.xz wic.xz wic.bmap"
IMAGE_FSTYPES:remove:rpi = "tar.bz2 wic.bz2 ext3"

inherit core-image features_check

# Add 'dbg-pkgs' to this list or to EXTRA_IMAGE_FEATURES in local.conf if
# you want debug symbols installed on the image. It is not added by default
# because it increases the image size quite a bit (from 4GB to 10GB unpacked)
IMAGE_FEATURES += " \
                    debug-tweaks \
                    dev-pkgs \
                    hwcodecs \
                    package-management \
                    ssh-server-openssh \
                    tools-debug \
                    tools-profile \
                    tools-sdk \
                    "
REQUIRED_DISTRO_FEATURES = "opengl wayland"

IMAGE_LINGUAS = "en-us es-es"
GLIBC_GENERATE_LOCALES = "en_US.UTF-8 es_ES.UTF-8"

# Extra tools
IMAGE_INSTALL:append = " \
    alsa-tools \
    alsa-utils-aconnect \
    alsa-utils-alsactl \
    alsa-utils-alsaloop \
    alsa-utils-alsamixer \
    alsa-utils-alsatplg \
    alsa-utils-amixer \
    alsa-utils-aplay \
    alsa-utils-midi \
    alsa-utils-speakertest \
    apache2 \
    apache2-scripts \
    bridge-utils \
    cmake \
    curl \
    dhcpcd \
    e2fsprogs-badblocks \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    e2fsprogs-resize2fs \
    e2fsprogs-tune2fs \
    ethtool \
    gdb \
    gdbserver \
    gi-docgen \
    glib-2.0-codegen \
    gperf \
    htop \
    iperf3 \
    ${@bb.utils.contains('PREFERRED_PROVIDER_virtual/egl', 'userland', '', 'kmscube', d)} \
    libdrm-tests \
    libtasn1 \
    lzo \
    mesa-demos \
    meson \
    nano \
    ninja \
    ntp \
    packagegroup-core-full-cmdline \
    parted \
    perf \
    pv \
    screen \
    sysprof \
    smem \
    systemd-analyze \
    unifdef \
    waylandeglinfo \
    wayland-tools \
    "

# vcgencmd and related tools for the RPi (works also with opensource stack)
IMAGE_INSTALL:append:rpi = " userland"

SDK_NATIVE_TOOLS = " \
    nativesdk-bison \
    nativesdk-ca-certificates \
    nativesdk-ccache \
    nativesdk-cmake \
    nativesdk-gi-docgen \
    nativesdk-glib-2.0-codegen \
    nativesdk-glib-2.0-utils \
    nativesdk-gperf \
    nativesdk-harfbuzz \
    nativesdk-libxml2 \
    nativesdk-libxml2-utils \
    nativesdk-ninja \
    nativesdk-perl \
    nativesdk-perl-misc \
    nativesdk-perl-module-findbin \
    nativesdk-perl-modules \
    nativesdk-python-is-python3 \
    nativesdk-python3 \
    nativesdk-python3-certifi \
    nativesdk-ruby \
    nativesdk-unifdef \
    nativesdk-wayland-dev \
    "

TOOLCHAIN_HOST_TASK:append = " ${SDK_NATIVE_TOOLS}"
TOOLCHAIN_TARGET_TASK:append = " openjpeg-staticdev libjxl"
TOOLCHAIN_TARGET_TASK:remove = "target-sdk-provides-dummy"

IMAGE_INSTALL:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'xwayland weston-xwayland', '', d)}"
IMAGE_INSTALL:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston-init weston-examples waylandeglinfo', '', d)}"
IMAGE_INSTALL:append = " ${@bb.utils.contains_any('DISTRO_FEATURES', 'x11 wayland', 'gtk4','',d)}"
IMAGE_INSTALL:append = " ${PREFERRED_PROVIDER_virtual/wpebackend}"
IMAGE_INSTALL:append = " packagegroup-wpewebkit-depends"


#
# Set a valid internal-sftp
#
ssh_internal_sftp () {
    for config in sshd_config sshd_config_readonly; do
        if [ -e ${IMAGE_ROOTFS}${sysconfdir}/ssh/$config ]; then
            sed -i 's/^[#[:space:]]*Subsystem sftp.*/Subsystem sftp internal-sftp/' ${IMAGE_ROOTFS}${sysconfdir}/ssh/$config
        fi
    done
}

#
# Some machines like the RPi have /boot on a separated partition
# and that causes that the rootfs tarball that is generated to miss
# the files needed for booting via NFS. This function will copy the
# IMAGE_BOOT_FILES on /boot in the rootfs to ensure that are also there.
#
copy_image_boot_files_to_slash_boot() {
    # Functions for un/escape special shell glob characters "*?[{"
    # Entries on IMAGE_BOOT_FILES can use glob patterns. See doc for it.
    escape_shell_glob_chars() {
        echo "$@" | sed -e 's/[*[?{]/\\&/g'
    }
    unescape_shell_glob_chars() {
        echo "$@" | sed -e 's/\\\([*[?{]\)/\1/g'
    }
    # Copy the files taking into care the optional globbing and dest dirs
    mkdir -p "${IMAGE_ROOTFS}/boot"
    for BOOTFILE_ENTRY in $(escape_shell_glob_chars "${IMAGE_BOOT_FILES}"); do
        if echo "${BOOTFILE_ENTRY}" | grep -q ';' ; then
            GLOBSRCPATH="${DEPLOY_DIR_IMAGE}/$(echo ${BOOTFILE_ENTRY} | cut -d\; -f1)"
            DSTPATH="$(echo ${BOOTFILE_ENTRY} | cut -d\; -f2)"
            if echo "${DSTPATH}" | grep -q '/'; then
                if echo "${DSTPATH}" | grep -qP '/$'; then
                    DSTPATH="${IMAGE_ROOTFS}/boot/${DSTPATH}"
                else
                    DSTPATH="${IMAGE_ROOTFS}/boot/$(dirname ${DSTPATH})"
                fi
                mkdir -p "${DSTPATH}"
            else
                DSTPATH="${IMAGE_ROOTFS}/boot/${DSTPATH}"
            fi
        else
            GLOBSRCPATH="${DEPLOY_DIR_IMAGE}/${BOOTFILE_ENTRY}"
            DSTPATH="${IMAGE_ROOTFS}/boot"
        fi
        for SRCPATH in $(unescape_shell_glob_chars "${GLOBSRCPATH}"); do
            cp "${SRCPATH}" "${DSTPATH}"
        done
    done
}

ROOTFS_POSTPROCESS_COMMAND += "ssh_internal_sftp; "
ROOTFS_POSTPROCESS_COMMAND:append:rpi = "copy_image_boot_files_to_slash_boot; "
