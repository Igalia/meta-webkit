require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
"

SRC_URI[tarball.sha256sum] = "381f1422cbc319db1aa42dda48de39590ed90ac3bec6b81ec83f3f2cae5c3eeb"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.4) wpebackend-fdo (< 1.6)"

SRC_URI_class-devupstream = "git://git.webkit.org/WebKit.git;branch=master"
# WPE 2.32.X branch is forked from the main branch in this commit
SRCREV_class-devupstream = "ed89819cebb141376ca22988844765637425e095"

