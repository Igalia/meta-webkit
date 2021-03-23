require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz \
    file://216455_builds_with_ENABLE_SERVICE_WORKER_OFF.patch \
"

SRC_URI[sha256sum] = "893a3098226f116bbb38a665a3053c7d30e3c5dca786b954f9aa38f8c8581468"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.4) wpebackend-fdo (< 1.6)"

SRC_URI_class-devupstream = "git://git.webkit.org/WebKit.git;branch=master"
SRCREV_class-devupstream = "8761d758f83fd7fda3d98a971cee02c38f765637"

