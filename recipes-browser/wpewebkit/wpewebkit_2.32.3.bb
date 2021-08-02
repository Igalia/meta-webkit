require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
"

SRC_URI[tarball.sha256sum] = "859bd1bbe51026aecfb2b6f5c8c024d88fb69ac6fcdc74c788c9fbe9499d740d"

DEPENDS += " libwpe"
RCONFLICTS:${PN} = "libwpe (< 1.4) wpebackend-fdo (< 1.6)"

SRC_URI:class-devupstream = "git://git.webkit.org/WebKit.git;branch=master"
# WPE 2.32.X branch is forked from the main branch in this commit
SRCREV:class-devupstream = "ed89819cebb141376ca22988844765637425e095"

