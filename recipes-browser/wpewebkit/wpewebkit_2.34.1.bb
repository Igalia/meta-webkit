require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
"

SRC_URI[tarball.sha256sum] = "cb336986341be9c3a9b1ca2c18de0d29d90ae4e77b9967a6f6879597e7a969f7"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.8) wpebackend-fdo (< 1.10)"

SRC_URI_class-devupstream = "git://git.webkit.org/WebKit.git;branch=master"
# WPE 2.34.X branch was forked from the main branch in this commit
SRCREV_class-devupstream = "30c41fe654d9556a5681663166c1461132326ff7"

# Needed for since >2.34.
PACKAGECONFIG[dfg-jit] = "-DENABLE_DFG_JIT=ON,-DENABLE_DFG_JIT=OFF,"
PACKAGECONFIG[jit] = "-DENABLE_JIT=ON,-DENABLE_JIT=OFF,"
PACKAGECONFIG[lcms] = "-DUSE_LCMS=ON,-DUSE_LCMS=OFF,"

PACKAGECONFIG_append = " dfg-jit"

# libsoup-3 will be available not before Poky kirkstone.
# http://git.yoctoproject.org/cgit/cgit.cgi/poky/commit/meta/recipes-support/libsoup/libsoup_3.0.1.bb?id=de296e2b2be876ca5cf2af309b710111e2b2581e
EXTRA_OECMAKE += "-DUSE_SOUP2=ON"

