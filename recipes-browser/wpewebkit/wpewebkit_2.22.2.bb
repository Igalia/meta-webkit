require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz \
           file://0001-REGRESSION-r217927-WPE-2.22-GSTREAMER_GL-Video-appea.patch \
          "

SRC_URI[md5sum] = "69c29ce376208b62b0cc43b750e27afb"
SRC_URI[sha256sum] = "56dced284e9fe71a7c56abc881b240251863472aed41c3e32ee3b071c21e56a9"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "wpebackend (< 1.0) wpebackend-fdo (< 1.0)"
