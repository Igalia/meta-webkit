require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz \
           file://0001-REGRESSION-r217927-WPE-2.22-GSTREAMER_GL-Video-appea.patch"

SRC_URI[md5sum] = "08778a95eba2de141d8aaff3d802c811"
SRC_URI[sha256sum] = "e75b1ca225fa9303017e954b6203e4f1750a7566fa852443e6fd574fd5f926b8"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "wpebackend (< 1.0) wpebackend-fdo (< 1.0)"