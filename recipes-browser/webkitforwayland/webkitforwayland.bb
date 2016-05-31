SUMMARY = "WebKit for Wayland port pairs the WebKit engine with the Wayland display protocol, \
           allowing embedders to create simple and performant systems based on Web platform technologies. \
           It is designed with hardware acceleration in mind, relying on EGL, the Wayland EGL platform, and OpenGL ES."
HOMEPAGE = "http://www.webkitforwayland.org/"
LICENSE = "BSD & LGPLv2+"
LIC_FILES_CHKSUM = "file://Source/WebCore/LICENSE-LGPL-2.1;md5=a778a33ef338abbaf8b8a7c36b6eec80 "

# you need harfbuzz with icu enabled, you can add this to your config:
# PACKAGECONFIG_append_pn-harfbuzz = " icu" if you are having problems
# with the do_configure step and harfbuzz.
DEPENDS = "zlib enchant libsoup-2.4 curl libxml2 cairo libxslt libidn gnutls \
           gtk+3 gstreamer1.0 gstreamer1.0-plugins-base flex-native icu \
           gperf-native perl-native perl-native-runtime ruby-native sqlite3 \
           libwebp harfbuzz virtual/libgles2 wayland weston mesa"


REQUIRED_DISTRO_FEATURES = "wayland"

inherit cmake pkgconfig perlnative pythonnative

#
# We download a tarball from github instead of cloning the git repository because
# requires less resources (network bandwidth and disk space) on the build machine.
#
# PV is the release or tag version (from https://github.com/WebKitForWayland/webkit/releases)
PV = "wpe-20160526"
S = "${WORKDIR}/webkit-${PV}/"

SRC_URI = "\
   https://github.com/WebKitForWayland/webkit/archive/${PV}.tar.gz \
   file://Downgrade-xdg-shell-protocol-for-Weston-1.6.patch \
"

SRC_URI[md5sum] = "1c004d643a16562eb4c54fef63365b4f"
SRC_URI[sha256sum] = "01ceafd5cfb07566e7c110bce4bf7fa9ad3e932939324e046de1d39dd7f10ee5"

EXTRA_OECMAKE = " \
                 -DPORT=WPE \
                 -DCMAKE_BUILD_TYPE=Release \
                "

# Javascript JIT is not supported on powerpc
EXTRA_OECMAKE_append_powerpc = " -DENABLE_JIT=OFF "
EXTRA_OECMAKE_append_powerpc64 = " -DENABLE_JIT=OFF "

# ARM JIT code does not build on ARMv5/6 anymore, apparently they test only on v7 onwards
EXTRA_OECMAKE_append_armv5 = " -DENABLE_JIT=OFF "
EXTRA_OECMAKE_append_armv6 = " -DENABLE_JIT=OFF "

# binutils 2.25.1 has a bug on aarch64:
# https://sourceware.org/bugzilla/show_bug.cgi?id=18430
EXTRA_OECMAKE_append_aarch64 = " -DUSE_LD_GOLD=OFF "

# JIT not supported on MIPS either
EXTRA_OECMAKE_append_mips = " -DENABLE_JIT=OFF "
EXTRA_OECMAKE_append_mips64 = " -DENABLE_JIT=OFF "

# We manually set the includes files for the binary and dev package here,
# (overriding the default settings) because some libraries (libWPE and
# libWPEWebInspectorResources) are not versioned, so we must include
# the .so file in the binary package instead of the dev one.
FILES_${PN}-dev = " \
${includedir} \
${libdir}/libWPE.so \
${libdir}/libWPEWebKit.so \
${libdir}/pkgconfig \
"
FILES_${PN} = " \
${bindir} \
${libdir}/libWPE.so.* \
${libdir}/libWPEWebInspectorResources.so \
${libdir}/libWPEWebKit.so.* \
"

RRECOMMENDS_${PN} += "ca-certificates"