SUMMARY = "WebKit web rendering engine for the GTK+ platform"
HOMEPAGE = "http://www.webkitgtk.org/"
BUGTRACKER = "http://bugs.webkit.org/"
LICENSE = "BSD & LGPLv2+"
LIC_FILES_CHKSUM = "file://Source/WebCore/LICENSE-LGPL-2.1;md5=a778a33ef338abbaf8b8a7c36b6eec80 "

# you need harfbuzz with icu enabled, you can add this to your config:
# PACKAGECONFIG_append_pn-harfbuzz = " icu"
DEPENDS = "zlib libsoup-2.4 curl libxml2 cairo libxslt libidn gnutls \
           gtk+3 gstreamer1.0 gstreamer1.0-plugins-base flex-native icu \
           gperf-native perl-native ruby-native ccache-native ninja-native \
           libwebp harfbuzz glib-2.0 gettext-native glib-2.0-native \
           sqlite3 libgcrypt"

SRC_URI = "https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz"
SRC_URI[sha256sum] = "136117317f70f66486f71b8edf5e46f8776403c5d8a296e914b11a36ef836917"

RRECOMMENDS_${PN} = "${PN}-bin \
                     ca-certificates \
                     shared-mime-info \
                     ttf-bitstream-vera \
                     ${@bb.utils.contains('PACKAGECONFIG', 'video', 'gstreamer1.0-plugins-base-meta gstreamer1.0-plugins-good-meta gstreamer1.0-plugins-bad-meta', '', d)} \
                     "
RRECOMMENDS_${PN}-bin = "adwaita-icon-theme librsvg-gtk"

inherit cmake lib_package pkgconfig perlnative python3native

# distro_features_check is going to be removed after dunfell
# ref: https://git.yoctoproject.org/cgit/cgit.cgi/poky/commit/meta/classes/features_check.bbclass?h=master-next&id=9702544b3e75d761d86cae7e8b36f3f2625b68ce
#   Temporarily support the old class name with a warning about future deprecation.
inherit ${@bb.utils.contains_any("LAYERSERIES_CORENAMES", 'zeus warrior thud sumo', 'distro_features_check', 'features_check', d)}

S = "${WORKDIR}/webkitgtk-${PV}"

# To build with embedded gl support -> Enable *both* "opengl" and "gles2" option
# To build with desktop  gl support -> Enable "opengl", but disable "gles2" option
PACKAGECONFIG ??= " ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
                    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland wperenderer', '', d)} \
                    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'opengl gles2 webgl', '', d)} \
                    enchant \
                    libsecret \
                    openjpeg \
                    video \
                    webcrypto \
                    woff2 \
                  "

PACKAGECONFIG[bubblewrap] = "-DENABLE_BUBBLEWRAP_SANDBOX=ON,-DENABLE_BUBBLEWRAP_SANDBOX=OFF,bubblewrap xdg-dbus-proxy bubblewrap-native xdg-dbus-proxy-native libseccomp"
PACKAGECONFIG[enchant] = "-DENABLE_SPELLCHECK=ON,-DENABLE_SPELLCHECK=OFF,enchant2"
PACKAGECONFIG[geoclue] = "-DENABLE_GEOLOCATION=ON,-DENABLE_GEOLOCATION=OFF,geoclue"
PACKAGECONFIG[gles2] = "-DENABLE_GLES2=ON,-DENABLE_GLES2=OFF,virtual/libgles2"
PACKAGECONFIG[libhyphen] = "-DUSE_LIBHYPHEN=ON,-DUSE_LIBHYPHEN=OFF,libhyphen"
PACKAGECONFIG[libnotify] = "-DUSE_LIBNOTIFY=ON,-DUSE_LIBNOTIFY=OFF,libnotify"
PACKAGECONFIG[libsecret] = "-DUSE_LIBSECRET=ON,-DUSE_LIBSECRET=OFF,libsecret"
PACKAGECONFIG[opengl] = "-DENABLE_OPENGL=ON,-DENABLE_OPENGL=OFF,virtual/libgl"
PACKAGECONFIG[openjpeg] = "-DUSE_OPENJPEG=ON,-DUSE_OPENJPEG=OFF,openjpeg"
PACKAGECONFIG[video] = "-DENABLE_VIDEO=ON,-DENABLE_VIDEO=OFF,gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad"
PACKAGECONFIG[wayland] = "-DENABLE_WAYLAND_TARGET=ON,-DENABLE_WAYLAND_TARGET=OFF,wayland wayland-native"
PACKAGECONFIG[webcrypto] = "-DENABLE_WEB_CRYPTO=ON,-DENABLE_WEB_CRYPTO=OFF,libgcrypt libtasn1"
PACKAGECONFIG[webgl] = "-DENABLE_WEBGL=ON,-DENABLE_WEBGL=OFF,virtual/libgl"
PACKAGECONFIG[woff2] = "-DUSE_WOFF2=ON,-DUSE_WOFF2=OFF,woff2"
PACKAGECONFIG[wperenderer] = "-DUSE_WPE_RENDERER=ON,-DUSE_WPE_RENDERER=OFF,libwpe wpebackend-fdo"
PACKAGECONFIG[x11] = "-DENABLE_X11_TARGET=ON,-DENABLE_X11_TARGET=OFF,virtual/libx11 libxt"


WEBKIT_BUILD_TYPE ??= "Release"

EXTRA_OECMAKE = " \
                 -DPORT=GTK \
                 -DCMAKE_BUILD_TYPE=${WEBKIT_BUILD_TYPE} \
                 -DENABLE_INTROSPECTION=OFF \
                 -DENABLE_GTKDOC=OFF \
                 -DENABLE_MINIBROWSER=ON \
                 -G Ninja \
                "

# Javascript JIT is not supported on powerpc
EXTRA_OECMAKE_append_powerpc = " -DENABLE_JIT=OFF "
EXTRA_OECMAKE_append_powerpc64 = " -DENABLE_JIT=OFF "

# ARM JIT code does not build on ARMv5/6 anymore, apparently they test only on v7 onwards
EXTRA_OECMAKE_append_armv4 = " -DENABLE_JIT=OFF "
EXTRA_OECMAKE_append_armv5 = " -DENABLE_JIT=OFF "
EXTRA_OECMAKE_append_armv6 = " -DENABLE_JIT=OFF "

# binutils 2.25.1 has a bug on aarch64:
# https://sourceware.org/bugzilla/show_bug.cgi?id=18430
EXTRA_OECMAKE_append_aarch64 = " -DUSE_LD_GOLD=OFF "

# JIT not supported on MIPS64 either
EXTRA_OECMAKE_append_mips64 = " -DENABLE_JIT=OFF "

# http://errors.yoctoproject.org/Errors/Details/20370/
ARM_INSTRUCTION_SET_armv4 = "arm"
ARM_INSTRUCTION_SET_armv5 = "arm"
ARM_INSTRUCTION_SET_armv6 = "arm"

# https://bugzilla.yoctoproject.org/show_bug.cgi?id=9474
# https://bugs.webkit.org/show_bug.cgi?id=159880
# JSC JIT can build on ARMv7 with -marm, but doesn't work on runtime.
# Upstream only tests regularly the JSC JIT on ARMv7 with Thumb2 (-mthumb).
ARM_INSTRUCTION_SET_armv7a = "thumb"
ARM_INSTRUCTION_SET_armv7r = "thumb"
ARM_INSTRUCTION_SET_armv7m = "thumb"
ARM_INSTRUCTION_SET_armv7ve = "thumb"

# Install MiniBrowser in PATH
do_install_append() {
    if test -f ${D}${libexecdir}/webkit2gtk-4.0/MiniBrowser; then
        mkdir -p ${D}${bindir}
        mv ${D}${libexecdir}/webkit2gtk-4.0/MiniBrowser ${D}${bindir}
    fi
}

FILES_${PN} += "${libdir}/webkit2gtk-4.0/injected-bundle/libwebkit2gtkinjectedbundle.so"
FILES_${PN}-dbg += "${libdir}/webkit2gtk-4.0/injected-bundle/.debug/libwebkit2gtkinjectedbundle.so"
FILES_${PN}-dbg += "${libdir}/webkitgtk/webkit2gtk-4.0/.debug/*"
