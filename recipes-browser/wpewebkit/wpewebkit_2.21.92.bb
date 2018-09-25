require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz \
           file://0001-REGRESSION-r217927-WPE-2.22-GSTREAMER_GL-Video-appea.patch \
           file://fix-189500.patch \
           file://fix-189506.patch \
           file://fix-189540.patch"

SRC_URI[md5sum] = "c5fcb3768067978741d8e72b1055ab8b"
SRC_URI[sha256sum] = "8ee366915aaf4f97950889863ac9951d21d94cae9c5f09d5f8e6efeb92069746"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "wpebackend (< 1.0) wpebackend-fdo (< 1.0)"
