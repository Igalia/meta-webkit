SUMMARY = "WebKit web rendering engine for the GTK+ platform"
HOMEPAGE = "http://www.webkitgtk.org/"
BUGTRACKER = "http://bugs.webkit.org/"
LICENSE = "BSD & LGPLv2+"
LIC_FILES_CHKSUM = "file://Source/WebCore/LICENSE-LGPL-2.1;md5=a778a33ef338abbaf8b8a7c36b6eec80 "

# you need harfbuzz with icu enabled, you can add this to your config:
# PACKAGECONFIG:append:pn-harfbuzz = " icu"
DEPENDS = "zlib libsoup-2.4 curl libxml2 cairo libxslt libidn \
           gtk+3 gstreamer1.0 gstreamer1.0-plugins-base flex-native icu \
           gperf-native perl-native ruby-native ccache-native ninja-native \
           libwebp harfbuzz glib-2.0 gettext-native glib-2.0-native \
           sqlite3 libgcrypt"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI = " \
    https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz;name=tarball \
"
SRC_URI[tarball.sha256sum] = "68930643af7a47a3af05f46d66e784422433753dab335d3282f319a85a5629b4"

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
                    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd', '' ,d)} \
                    enchant \
                    gold \
                    jit \
                    libsecret \
                    openjpeg \
                    video \
                    webcrypto \
                    woff2 \
                  "

PACKAGECONFIG[reduce-size] = "-DCMAKE_BUILD_TYPE=MinSizeRel,-DCMAKE_BUILD_TYPE=Release,,"
PACKAGECONFIG[bubblewrap] = "-DENABLE_BUBBLEWRAP_SANDBOX=ON,-DENABLE_BUBBLEWRAP_SANDBOX=OFF,bubblewrap xdg-dbus-proxy bubblewrap-native xdg-dbus-proxy-native libseccomp"
PACKAGECONFIG[enchant] = "-DENABLE_SPELLCHECK=ON,-DENABLE_SPELLCHECK=OFF,enchant2"
PACKAGECONFIG[gamepad] = "-DENABLE_GAMEPAD=ON,-DENABLE_GAMEPAD=OFF,libmanette"
PACKAGECONFIG[geoclue] = "-DENABLE_GEOLOCATION=ON,-DENABLE_GEOLOCATION=OFF,geoclue"
PACKAGECONFIG[gles2] = "-DENABLE_GLES2=ON,-DENABLE_GLES2=OFF,virtual/libgles2"
PACKAGECONFIG[libhyphen] = "-DUSE_LIBHYPHEN=ON,-DUSE_LIBHYPHEN=OFF,libhyphen"
PACKAGECONFIG[libnotify] = "-DUSE_LIBNOTIFY=ON,-DUSE_LIBNOTIFY=OFF,libnotify"
PACKAGECONFIG[libsecret] = "-DUSE_LIBSECRET=ON,-DUSE_LIBSECRET=OFF,libsecret"
PACKAGECONFIG[opengl] = "-DENABLE_OPENGL=ON,-DENABLE_OPENGL=OFF,virtual/libgl"
PACKAGECONFIG[openjpeg] = "-DUSE_OPENJPEG=ON,-DUSE_OPENJPEG=OFF,openjpeg"
PACKAGECONFIG[systemd] = "-DUSE_SYSTEMD=ON,-DUSE_SYSTEMD=OFF,systemd"
PACKAGECONFIG[video] = "-DENABLE_VIDEO=ON,-DENABLE_VIDEO=OFF,gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad"
PACKAGECONFIG[wayland] = "-DENABLE_WAYLAND_TARGET=ON,-DENABLE_WAYLAND_TARGET=OFF,wayland wayland-native"
PACKAGECONFIG[webcrypto] = "-DENABLE_WEB_CRYPTO=ON,-DENABLE_WEB_CRYPTO=OFF,libgcrypt libtasn1"
PACKAGECONFIG[webgl] = "-DENABLE_WEBGL=ON,-DENABLE_WEBGL=OFF,virtual/libgl"
PACKAGECONFIG[woff2] = "-DUSE_WOFF2=ON,-DUSE_WOFF2=OFF,woff2"
PACKAGECONFIG[wperenderer] = "-DUSE_WPE_RENDERER=ON,-DUSE_WPE_RENDERER=OFF,libwpe wpebackend-fdo"
PACKAGECONFIG[x11] = "-DENABLE_X11_TARGET=ON,-DENABLE_X11_TARGET=OFF,virtual/libx11 libxt"
PACKAGECONFIG[jit] = "-DENABLE_JIT=ON -DENABLE_C_LOOP=OFF,-DENABLE_JIT=OFF -DENABLE_C_LOOP=ON,"
PACKAGECONFIG[gold] = "-DUSE_LD_GOLD=ON,-DUSE_LD_GOLD=OFF,"

EXTRA_OECMAKE = " \
                 -DPORT=GTK \
                 -DENABLE_INTROSPECTION=OFF \
                 -DENABLE_GTKDOC=OFF \
                 -DENABLE_MINIBROWSER=ON \
                 -DUSE_SOUP2=ON \
                 -G Ninja \
                "

# Javascript JIT is not supported on ppc/arm < v6/RISCV/mips64 and disable gold on mips/riscv
PACKAGECONFIG:remove:powerpc = "jit"
PACKAGECONFIG:remove:powerpc64 = "jit"
PACKAGECONFIG:remove:powerpc64le = "jit"
PACKAGECONFIG:remove:armv4 = "jit"
PACKAGECONFIG:remove:armv5 = "jit"
PACKAGECONFIG:remove:armv6 = "jit"
PACKAGECONFIG:remove:riscv32 = "jit gold"
PACKAGECONFIG:remove:riscv64 = "jit gold"
PACKAGECONFIG:remove:mipsarchn64 = "jit gold"
PACKAGECONFIG:remove:mipsarchn32 = "jit gold"
PACKAGECONFIG:remove:mipsarcho32 = "gold"

# binutils 2.25.1 has a bug on aarch64:
# https://sourceware.org/bugzilla/show_bug.cgi?id=18430
PACKAGECONFIG:remove:aarch64 = "gold"

# http://errors.yoctoproject.org/Errors/Details/20370/
ARM_INSTRUCTION_SET:armv4 = "arm"
ARM_INSTRUCTION_SET:armv5 = "arm"
ARM_INSTRUCTION_SET:armv6 = "arm"

# https://bugzilla.yoctoproject.org/show_bug.cgi?id=9474
# https://bugs.webkit.org/show_bug.cgi?id=159880
# JSC JIT can build on ARMv7 with -marm, but doesn't work on runtime.
# Upstream only tests regularly the JSC JIT on ARMv7 with Thumb2 (-mthumb).
ARM_INSTRUCTION_SET:armv7a = "thumb"
ARM_INSTRUCTION_SET:armv7r = "thumb"
ARM_INSTRUCTION_SET:armv7m = "thumb"
ARM_INSTRUCTION_SET:armv7ve = "thumb"

# Install MiniBrowser in PATH
do_install:append() {
    if test -f ${D}${libexecdir}/webkit2gtk-4.0/MiniBrowser; then
        mkdir -p ${D}${bindir}
        mv ${D}${libexecdir}/webkit2gtk-4.0/MiniBrowser ${D}${bindir}
    fi
}

FILES:${PN} += "${libdir}/webkit2gtk-4.0/injected-bundle/libwebkit2gtkinjectedbundle.so"
FILES:${PN}-dbg += "${libdir}/webkit2gtk-4.0/injected-bundle/.debug/libwebkit2gtkinjectedbundle.so"
FILES:${PN}-dbg += "${libdir}/webkitgtk/webkit2gtk-4.0/.debug/*"
