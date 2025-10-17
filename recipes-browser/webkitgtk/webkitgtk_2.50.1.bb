SUMMARY = "WebKit web rendering engine for the GTK+ platform"
HOMEPAGE = "http://www.webkitgtk.org/"
BUGTRACKER = "http://bugs.webkit.org/"

LICENSE = "BSD-2-Clause & LGPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Source/JavaScriptCore/COPYING.LIB;md5=d0c6d6397a5d84286dda758da57bd691 \
                    file://Source/WebCore/LICENSE-APPLE;md5=4646f90082c40bcf298c285f8bab0b12 \
                    file://Source/WebCore/LICENSE-LGPL-2;md5=36357ffde2b64ae177b2494445b79d21 \
                    file://Source/WebCore/LICENSE-LGPL-2.1;md5=a778a33ef338abbaf8b8a7c36b6eec80 \
                    "

# you need harfbuzz with icu enabled, you can add this to your config:
# PACKAGECONFIG:append:pn-harfbuzz = " icu"
DEPENDS = "curl \
           flex-native \
           gettext-native \
           glib-2.0 glib-2.0-native \
           gperf-native \
           gstreamer1.0 gstreamer1.0-plugins-base \
           gtk+3 \
           harfbuzz \
           icu \
           libavif \
           libgcrypt \
           libidn \
           libsoup \
           libtasn1 \
           libwebp \
           libxml2 libxslt \
           ninja-native \
           perl-native \
           python3-native python3-packaging-native \
           ruby-native \
           sqlite3 \
           unifdef-native \
           zlib \
"

SRC_URI = "https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz;name=tarball"
SRC_URI[tarball.sha256sum] = "33e912ee6e3cdb4b9803715f50686af85a60af47f1cf72a6acc6a2db1bb3d9fe"

RRECOMMENDS:${PN} = "${PN}-bin \
                     ca-certificates \
                     shared-mime-info \
                     ttf-dejavu-sans \
                     ttf-dejavu-sans-mono \
                     ttf-dejavu-serif \
                     ${@bb.utils.contains('PACKAGECONFIG', 'video', 'gstreamer1.0-plugins-base-meta gstreamer1.0-plugins-good-meta gstreamer1.0-plugins-bad-meta', '', d)} \
                     "
RRECOMMENDS:${PN}-bin = "adwaita-icon-theme librsvg-gtk"

inherit cmake lib_package pkgconfig perlnative python3native

# To build with embedded gl support -> Enable *both* "opengl" and "gles2" option
# To build with desktop  gl support -> Enable "opengl", but disable "gles2" option
PACKAGECONFIG ??= " ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
                    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)} \
                    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'opengl gles2 webgl', '', d)} \
                    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'journald', '' ,d)} \
                   enchant \
                   gbm \
                   gtk4 \
                   jit \
                   jpegxl \
                   libsecret \
                   pdfjs \
                   speech-synthesis \
                   video \
                   woff2 \
                   "

PACKAGECONFIG[reduce-size] = "-DCMAKE_BUILD_TYPE=MinSizeRel,-DCMAKE_BUILD_TYPE=Release,,"
PACKAGECONFIG[bubblewrap] = "-DENABLE_BUBBLEWRAP_SANDBOX=ON -DBWRAP_EXECUTABLE=${bindir}/bwrap -DDBUS_PROXY_EXECUTABLE=${bindir}/xdg-dbus-proxy,-DENABLE_BUBBLEWRAP_SANDBOX=OFF,bubblewrap xdg-dbus-proxy libseccomp"
PACKAGECONFIG[enchant] = "-DENABLE_SPELLCHECK=ON,-DENABLE_SPELLCHECK=OFF,enchant2"
PACKAGECONFIG[gamepad] = "-DENABLE_GAMEPAD=ON,-DENABLE_GAMEPAD=OFF,libmanette"
PACKAGECONFIG[gbm] = "-DUSE_GBM=ON,-DUSE_GBM=OFF,libdrm"
PACKAGECONFIG[geoclue] = "-DENABLE_GEOLOCATION=ON,-DENABLE_GEOLOCATION=OFF,geoclue"
PACKAGECONFIG[gles2] = "-DENABLE_GLES2=ON,-DENABLE_GLES2=OFF,virtual/libgles2"
PACKAGECONFIG[gtk4] = "-DUSE_GTK4=ON,-DUSE_GTK4=OFF,gtk4"
PACKAGECONFIG[jpegxl] = "-DUSE_JPEGXL=ON,-DUSE_JPEGXL=OFF,libjxl"
PACKAGECONFIG[libbacktrace] = "-DUSE_LIBBACKTRACE=ON,-DUSE_LIBBACKTRACE=OFF,libbacktrace"
PACKAGECONFIG[libhyphen] = "-DUSE_LIBHYPHEN=ON,-DUSE_LIBHYPHEN=OFF,libhyphen"
PACKAGECONFIG[libsecret] = "-DUSE_LIBSECRET=ON,-DUSE_LIBSECRET=OFF,libsecret"
PACKAGECONFIG[opengl] = "-DUSE_OPENGL_OR_ES=ON,-DUSE_OPENGL_OR_ES=OFF,virtual/libgl"
# pdfjs adds +3MB to the binary size of libwebkitgtk
PACKAGECONFIG[pdfjs] = "-DENABLE_PDFJS=ON,-DENABLE_PDFJS=OFF,"
PACKAGECONFIG[speech-synthesis] = "-DENABLE_SPEECH_SYNTHESIS=ON,-DENABLE_SPEECH_SYNTHESIS=OFF,flite"
PACKAGECONFIG[systemd] = "-DUSE_SYSTEMD=ON,-DUSE_SYSTEMD=OFF,systemd"
PACKAGECONFIG[journald] = "-DENABLE_JOURNALD_LOG=ON,-DENABLE_JOURNALD_LOG=OFF,"
PACKAGECONFIG[video] = "-DENABLE_VIDEO=ON,-DENABLE_VIDEO=OFF,gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad"
PACKAGECONFIG[wayland] = "-DENABLE_WAYLAND_TARGET=ON,-DENABLE_WAYLAND_TARGET=OFF,wayland wayland-native"
PACKAGECONFIG[webgl] = "-DENABLE_WEBGL=ON,-DENABLE_WEBGL=OFF,virtual/libgl"
PACKAGECONFIG[woff2] = "-DUSE_WOFF2=ON,-DUSE_WOFF2=OFF,woff2"
PACKAGECONFIG[x11] = "-DENABLE_X11_TARGET=ON,-DENABLE_X11_TARGET=OFF,virtual/libx11 libxt"
PACKAGECONFIG[jit] = "-DENABLE_JIT=ON -DENABLE_C_LOOP=OFF,-DENABLE_JIT=OFF -DENABLE_C_LOOP=ON,"

EXTRA_OECMAKE = "\
    -DPORT=GTK \
    -DENABLE_INTROSPECTION=OFF \
    -DENABLE_GTKDOC=OFF \
    -DENABLE_MINIBROWSER=ON \
    -DUSE_SYSPROF_CAPTURE=OFF \
    -G Ninja \
"

# Unless DEBUG_BUILD is enabled, pass -g1 to massively reduce the size of the
# debug symbols (4.3GB to 700M at time of writing)
DEBUG_FLAGS:append = "${@bb.utils.contains('LAYERSERIES_CORENAMES', 'scarthgap', oe.utils.vartrue('DEBUG_BUILD', '', ' -g1', d), '', d)}"
DEBUG_LEVELFLAG = "${@bb.utils.contains('LAYERSERIES_CORENAMES', 'scarthgap', '', '-g1', d)}"

# Javascript JIT is not supported on ppc/arm < v6/RISCV/mips64
PACKAGECONFIG:remove:powerpc = "jit"
PACKAGECONFIG:remove:powerpc64 = "jit"
PACKAGECONFIG:remove:powerpc64le = "jit"
PACKAGECONFIG:remove:armv4 = "jit"
PACKAGECONFIG:remove:armv5 = "jit"
PACKAGECONFIG:remove:armv6 = "jit"
PACKAGECONFIG:remove:riscv32 = "jit"
PACKAGECONFIG:remove:riscv64 = "jit"
PACKAGECONFIG:remove:mipsarchn64 = "jit"
PACKAGECONFIG:remove:mipsarchn32 = "jit"

# https://bugs.debian.org/cgi-bin/bugreport.cgi?bug=949621
LDFLAGS += "-Wl,--reduce-memory-overheads"

# http://errors.yoctoproject.org/Errors/Details/20370/
ARM_INSTRUCTION_SET:armv4 = "arm"
ARM_INSTRUCTION_SET:armv5 = "arm"
ARM_INSTRUCTION_SET:armv6 = "arm"

# Can't be built with ccache
CCACHE_DISABLE = "1"

# https://bugzilla.yoctoproject.org/show_bug.cgi?id=9474
# https://bugs.webkit.org/show_bug.cgi?id=159880
# JSC JIT can build on ARMv7 with -marm, but doesn't work on runtime.
# Upstream only tests regularly the JSC JIT on ARMv7 with Thumb2 (-mthumb).
ARM_INSTRUCTION_SET:armv7a = "thumb"
ARM_INSTRUCTION_SET:armv7r = "thumb"
ARM_INSTRUCTION_SET:armv7m = "thumb"
ARM_INSTRUCTION_SET:armv7ve = "thumb"

WEBKITGTK_API_VERSION := "6.0"

# Install MiniBrowser in PATH
do_install:append() {
    if test -f "${D}${libexecdir}/webkitgtk-${WEBKITGTK_API_VERSION}" ; then
        install -d ${D}${bindir}
        mv ${D}${libexecdir}/webkitgtk-${WEBKITGTK_API_VERSION}/MiniBrowser ${D}${bindir}
    fi
}

FILES:${PN} += "${libdir}/webkitgtk-${WEBKITGTK_API_VERSION}/injected-bundle/libwebkitgtkinjectedbundle.so"
FILES:${PN}-dbg += "${libdir}/webkitgtk-${WEBKITGTK_API_VERSION}/injected-bundle/.debug/libwebkitgtkinjectedbundle.so"
FILES:${PN}-dbg += "${libexecdir}/webkitgtk-${WEBKITGTK_API_VERSION}/.debug/*"

PACKAGE_PREPROCESS_FUNCS += "src_package_preprocess"
src_package_preprocess () {
        # Trim build paths from comments in generated sources to ensure reproducibility
        sed -i -e "s,${WORKDIR},,g" \
            ${B}/JavaScriptCore/DerivedSources/*.h \
            ${B}/JavaScriptCore/DerivedSources/yarr/*.h \
            ${B}/JavaScriptCore/PrivateHeaders/JavaScriptCore/*.h \
            ${B}/WebCore/DerivedSources/*.cpp \
            ${B}/WebKitGTK/DerivedSources/webkit/*.cpp
}

