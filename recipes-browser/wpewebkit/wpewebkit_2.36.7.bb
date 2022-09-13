require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-Fix-include-path-gstreamer-on-cross-toolchain.patch \
           "

SRC_URI[tarball.sha256sum] = "f3747d72ffc562ad0cfb6218fdf6d897c78c4bdbf5618e0fa26906fba52b95c9"

DEPENDS += " libwpe"
RCONFLICTS:${PN} = "libwpe (< 1.10) wpebackend-fdo (< 1.10)"

SRC_URI:class-devupstream = "\
    git://github.com/WebKit/WebKit.git;protocol=https;branch=main \
    file://0002-libyuv-gcc-issue.patch \
"
# WPE 2.36.X branch was forked from the main branch in this commit
SRCREV:class-devupstream = "b3f12a91b11b34b71aa4ec64c1806616b45bd877"

# Needed from 2.36
PACKAGECONFIG[journald] = "-DENABLE_JOURNALD_LOG=ON,-DENABLE_JOURNALD_LOG=OFF,"
PACKAGECONFIG:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'journald', '' ,d)}"

