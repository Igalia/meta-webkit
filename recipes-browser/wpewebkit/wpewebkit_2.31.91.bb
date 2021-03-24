require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz \
    file://0001-EME-Fix-KeySystem-permission-handling.patch \
    file://274943-GStreamer-Use-imxvideoconvert_g2d-element-inside-the.patch \
"

SRC_URI[sha256sum] = "e5bea1323ad810533bcb7ec7918b4bc2d342b0ea2a2fa61a3063cdd019bcd3f0"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.4) wpebackend-fdo (< 1.6)"

SRC_URI_class-devupstream = "git://git.webkit.org/WebKit.git;branch=master"
SRCREV_class-devupstream = "8761d758f83fd7fda3d98a971cee02c38f765637"

# This is a pre-release, so de-prioritise compared to stable releases.
DEFAULT_PREFERENCE = "-1"
