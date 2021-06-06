require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
"

SRC_URI[tarball.sha256sum] = "7b6b39a12ccf3f84da4cc6ac59e02fbe328f7476eaeb9c23de9b9288c2c2f39c"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.4) wpebackend-fdo (< 1.6)"

SRC_URI_class-devupstream = "git://git.webkit.org/WebKit.git;branch=master"
SRCREV_class-devupstream = "b410adfdbd2835d90a4bf86282ba742448848c94"

