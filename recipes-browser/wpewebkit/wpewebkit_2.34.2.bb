require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
"

SRC_URI[tarball.sha256sum] = "b1a3733c2d486c4da27f9636ccc39947da7d84258cd7a24a6fb0b842c9595c0b"

DEPENDS += " libwpe"
RCONFLICTS:${PN} = "libwpe (< 1.8) wpebackend-fdo (< 1.10)"

SRC_URI_class-devupstream = "\
    git://git.webkit.org/WebKit.git;branch=master \
    file://0002-libyuv-gcc-issue.patch \
"
# WPE 2.34.X branch was forked from the main branch in this commit
SRCREV:class-devupstream = "30c41fe654d9556a5681663166c1461132326ff7"

# Needed for since >2.34.
PACKAGECONFIG[dfg-jit] = "-DENABLE_DFG_JIT=ON,-DENABLE_DFG_JIT=OFF,"
PACKAGECONFIG[jit] = "-DENABLE_JIT=ON,-DENABLE_JIT=OFF,"
PACKAGECONFIG[lcms] = "-DUSE_LCMS=ON,-DUSE_LCMS=OFF,"

PACKAGECONFIG:append = " dfg-jit"

# libsoup-3 will be available not before Poky kirkstone.
# http://git.yoctoproject.org/cgit/cgit.cgi/poky/commit/meta/recipes-support/libsoup/libsoup_3.0.1.bb?id=de296e2b2be876ca5cf2af309b710111e2b2581e
EXTRA_OECMAKE += "-DUSE_SOUP2=ON"

