require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball"

SRC_URI[tarball.sha256sum] = "e653e12eca63e6371c06d4cd9efcd5492db67f7d9ef324fd5d8668b1151e72b2"

DEPENDS += " libwpe"
RCONFLICTS:${PN} = "libwpe (< 1.12)"

SRC_URI:class-devupstream = "\
    git://github.com/WebKit/WebKit.git;protocol=https;branch=main \
"

# WPE 2.38.X branch was forked from the main branch in this commit
SRCREV:class-devupstream = "ab63faf432abcb7cfc469fbb1a0d2a89c94cfa20"

