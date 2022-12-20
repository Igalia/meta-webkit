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
XZ_COMPRESSION_LEVEL ?= "-6"
SDK_XZ_COMPRESSION_LEVEL ?= "-0"

inherit core-image features_check

# Add 'dbg-pkgs' to this list or to EXTRA_IMAGE_FEATURES in local.conf if
# you want debug symbols installed on the image. It is not added by default
# because it increases the image size quite a bit (from 4GB to 10GB unpacked)
IMAGE_FEATURES += " \
                    debug-tweaks \
                    dev-pkgs \
                    hwcodecs \
                    package-management \
                    splash \
                    ssh-server-openssh \
                    tools-debug \
                    tools-profile \
                    tools-sdk \
                    tools-testapps \
                    "
REQUIRED_DISTRO_FEATURES = "opengl wayland"

IMAGE_LINGUAS = "en-us es-es"
GLIBC_GENERATE_LOCALES = "en_US.UTF-8 es_ES.UTF-8"

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
    apache2 apache2-scripts \
    bridge-utils \
    curl\
    dhcpcd \
    e2fsprogs-badblocks \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    e2fsprogs-resize2fs \
    e2fsprogs-tune2fs \
    gdb \
    gdbserver \
    htop \
    libtasn1 \
    lzo \
    nano \
    ntp \
    packagegroup-core-full-cmdline \
    parted \
    perf \
    pv \
    smem \
    systemd-analyze \
    "

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

TOOLCHAIN_HOST_TASK:append = "${SDK_NATIVE_TOOLS}"
TOOLCHAIN_TARGET_TASK:append = " openjpeg-staticdev libjxl"
TOOLCHAIN_TARGET_TASK:remove = "target-sdk-provides-dummy"

IMAGE_INSTALL:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'xwayland weston-xwayland', '', d)}"
IMAGE_INSTALL:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston-init weston-examples waylandeglinfo', '', d)}"
IMAGE_INSTALL:append = " ${PREFERRED_PROVIDER_virtual/wpebackend}"
IMAGE_INSTALL:append = " packagegroup-wpewebkit-depends"

# Allow dropbear/openssh to accept root logins if debug-tweaks or allow-root-login is enabled
ROOTFS_POSTPROCESS_COMMAND += "ssh_internal_sftp; "

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
