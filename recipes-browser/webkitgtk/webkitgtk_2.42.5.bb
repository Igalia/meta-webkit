SUMMARY = "WebKit web rendering engine for the GTK+ platform"
HOMEPAGE = "http://www.webkitgtk.org/"
BUGTRACKER = "http://bugs.webkit.org/"
LICENSE = "BSD & LGPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Source/WebCore/LICENSE-LGPL-2.1;md5=a778a33ef338abbaf8b8a7c36b6eec80 "

# WebKit 2.42 requires GCC>=10 (not provided in dunfell) or Clang>=10
# (provided by meta-clang in dunfell)
TOOLCHAIN = "${@bb.utils.contains_any("LAYERSERIES_CORENAMES", 'dunfell', 'clang', 'gcc', d)}"
LIBCPLUSPLUS = "${@bb.utils.contains_any("LAYERSERIES_CORENAMES", 'dunfell', '--stdlib=libc++', '', d)}"

# you need harfbuzz with icu enabled, you can add this to your config:
# PACKAGECONFIG:append:pn-harfbuzz = " icu"
DEPENDS = "zlib libsoup-2.4 curl libxml2 cairo libxslt libidn \
           gtk+3 gstreamer1.0 gstreamer1.0-plugins-base flex-native icu \
           gperf-native perl-native ruby-native ninja-native \
           libwebp harfbuzz glib-2.0 gettext-native glib-2.0-native \
           sqlite3 libgcrypt \
           unifdef-native \
           libavif \
           ${@bb.utils.contains_any('LAYERSERIES_CORENAMES', 'dunfell gatesgarth hardknott honister', 'libsoup-2.4', 'libsoup', d)} \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI = " \
    https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz;name=tarball \
    file://0001-Activate-HAVE_MISSING_STD_FILESYSTEM_PATH_CONSTRUCTO.patch \
"

SRC_URI[tarball.sha256sum] = "b64278c1f20b8cfdbfb5ff573c37d871aba74a1db26d9b39f74e8953fe61e749"

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

S = "${WORKDIR}/webkitgtk-${PV}"

# To build with embedded gl support -> Enable *both* "opengl" and "gles2" option
# To build with desktop  gl support -> Enable "opengl", but disable "gles2" option
PACKAGECONFIG ??= " ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
                    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland wperenderer', '', d)} \
                    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'opengl gles2 webgl', '', d)} \
                    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'journald', '' ,d)} \
                    enchant \
                    gbm \
                    jit \
                    ${@bb.utils.contains_any('LAYERSERIES_CORENAMES', 'dunfell gatesgarth hardknott honister', '', 'jpegxl', d)} \
                    libsecret \
                    openjpeg \
                    video \
                    webcrypto \
                    woff2 \
                  "

PACKAGECONFIG[reduce-size] = "-DCMAKE_BUILD_TYPE=MinSizeRel,-DCMAKE_BUILD_TYPE=Release,,"
PACKAGECONFIG[bubblewrap] = "-DENABLE_BUBBLEWRAP_SANDBOX=ON -DBWRAP_EXECUTABLE=${bindir}/bwrap -DDBUS_PROXY_EXECUTABLE=${bindir}/xdg-dbus-proxy,-DENABLE_BUBBLEWRAP_SANDBOX=OFF,bubblewrap xdg-dbus-proxy libseccomp"
PACKAGECONFIG[enchant] = "-DENABLE_SPELLCHECK=ON,-DENABLE_SPELLCHECK=OFF,enchant2"
PACKAGECONFIG[gamepad] = "-DENABLE_GAMEPAD=ON,-DENABLE_GAMEPAD=OFF,libmanette"
PACKAGECONFIG[gbm] = "-DUSE_GBM=ON,-DUSE_GBM=OFF,libdrm"
PACKAGECONFIG[geoclue] = "-DENABLE_GEOLOCATION=ON,-DENABLE_GEOLOCATION=OFF,geoclue"
PACKAGECONFIG[gles2] = "-DENABLE_GLES2=ON,-DENABLE_GLES2=OFF,virtual/libgles2"
PACKAGECONFIG[jpegxl] = "-DUSE_JPEGXL=ON,-DUSE_JPEGXL=OFF,libjxl"
PACKAGECONFIG[libhyphen] = "-DUSE_LIBHYPHEN=ON,-DUSE_LIBHYPHEN=OFF,libhyphen"
PACKAGECONFIG[libsecret] = "-DUSE_LIBSECRET=ON,-DUSE_LIBSECRET=OFF,libsecret"
PACKAGECONFIG[opengl] = "-DUSE_OPENGL_OR_ES=ON,-DUSE_OPENGL_OR_ES=OFF,virtual/libgl"
PACKAGECONFIG[openjpeg] = "-DUSE_OPENJPEG=ON,-DUSE_OPENJPEG=OFF,openjpeg"
PACKAGECONFIG[soup2] = "-DUSE_SOUP2=ON,-DUSE_SOUP2=OFF,libsoup-2.4"
PACKAGECONFIG[systemd] = "-DUSE_SYSTEMD=ON,-DUSE_SYSTEMD=OFF,systemd"
PACKAGECONFIG[journald] = "-DENABLE_JOURNALD_LOG=ON,-DENABLE_JOURNALD_LOG=OFF,"
PACKAGECONFIG[video] = "-DENABLE_VIDEO=ON,-DENABLE_VIDEO=OFF,gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad"
PACKAGECONFIG[wayland] = "-DENABLE_WAYLAND_TARGET=ON,-DENABLE_WAYLAND_TARGET=OFF,wayland wayland-native"
PACKAGECONFIG[webcrypto] = "-DENABLE_WEB_CRYPTO=ON,-DENABLE_WEB_CRYPTO=OFF,libgcrypt libtasn1"
PACKAGECONFIG[webgl] = "-DENABLE_WEBGL=ON,-DENABLE_WEBGL=OFF,virtual/libgl"
PACKAGECONFIG[woff2] = "-DUSE_WOFF2=ON,-DUSE_WOFF2=OFF,woff2"
PACKAGECONFIG[wperenderer] = "-DUSE_WPE_RENDERER=ON,-DUSE_WPE_RENDERER=OFF,libwpe wpebackend-fdo"
PACKAGECONFIG[x11] = "-DENABLE_X11_TARGET=ON,-DENABLE_X11_TARGET=OFF,virtual/libx11 libxt"
PACKAGECONFIG[jit] = "-DENABLE_JIT=ON -DENABLE_C_LOOP=OFF,-DENABLE_JIT=OFF -DENABLE_C_LOOP=ON,"

EXTRA_OECMAKE = " \
                 -DPORT=GTK \
                 -DENABLE_INTROSPECTION=OFF \
                 -DENABLE_GTKDOC=OFF \
                 -DENABLE_MINIBROWSER=ON \
                 ${@bb.utils.contains_any("LAYERSERIES_CORENAMES", 'dunfell gatesgarth', '-DUSE_GSTREAMER_TRANSCODER=OFF', '', d)} \
                 -G Ninja \
                "

# libsoup-3 is not available before Poky kirkstone.
# http://git.yoctoproject.org/cgit/cgit.cgi/poky/commit/meta/recipes-support/libsoup/libsoup_3.0.1.bb?id=de296e2b2be876ca5cf2af309b710111e2b2581e
PACKAGECONFIG:append = " ${@bb.utils.contains_any('LAYERSERIES_CORENAMES', 'dunfell gatesgarth hardknott honister', 'soup2', '', d)}"

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

# Execdir is webkit2gtk-4.0 or webkit2gtk-4.1 depends on if USE_SOUP
# is or not enabled.
WEBKITGTK_API_VERSION := "${@bb.utils.contains('PACKAGECONFIG', 'soup2', '4.0', '4.1', d)}"

# Install MiniBrowser in PATH
do_install:append() {
    if test -f "${D}${libexecdir}/webkit2gtk-${WEBKITGTK_API_VERSION}" ; then
        install -d ${D}${bindir}
        mv ${D}${libexecdir}/webkit2gtk-${WEBKITGTK_API_VERSION}/MiniBrowser ${D}${bindir}
    fi
}

FILES:${PN} += "${libdir}/webkit2gtk-${WEBKITGTK_API_VERSION}/injected-bundle/libwebkit2gtkinjectedbundle.so"
FILES:${PN}-dbg += "${libdir}/webkit2gtk-${WEBKITGTK_API_VERSION}/injected-bundle/.debug/libwebkit2gtkinjectedbundle.so"
FILES:${PN}-dbg += "${libdir}/webkitgtk/webkit2gtk-${WEBKITGTK_API_VERSION}/.debug/*"
