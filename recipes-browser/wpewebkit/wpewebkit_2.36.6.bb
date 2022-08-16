require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-Fix-include-path-gstreamer-on-cross-toolchain.patch \
           "

SRC_URI[tarball.sha256sum] = "e98a4eae2464ffaf4e5b53be08b9ae6386db511015c8002918b824d29f05d58f"

DEPENDS += " libwpe"
RCONFLICTS:${PN} = "libwpe (< 1.10) wpebackend-fdo (< 1.10)"

SRC_URI:class-devupstream = "\
    git://git.webkit.org/WebKit.git;branch=master \
    file://0002-libyuv-gcc-issue.patch \
"
# WPE 2.36.X branch was forked from the main branch in this commit
SRCREV:class-devupstream = "b3f12a91b11b34b71aa4ec64c1806616b45bd877"

# Needed from 2.36
PACKAGECONFIG[journald] = "-DENABLE_JOURNALD_LOG=ON,-DENABLE_JOURNALD_LOG=OFF,"
PACKAGECONFIG:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'journald', '' ,d)}"

# libsoup-3 will be available not before Poky kirkstone.
# http://git.yoctoproject.org/cgit/cgit.cgi/poky/commit/meta/recipes-support/libsoup/libsoup_3.0.1.bb?id=de296e2b2be876ca5cf2af309b710111e2b2581e
EXTRA_OECMAKE += "-DUSE_SOUP2=ON"

