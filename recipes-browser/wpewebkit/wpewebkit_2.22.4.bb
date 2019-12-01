require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz \
           file://0001-REGRESSION-r217927-WPE-2.22-GSTREAMER_GL-Video-appea.patch \
          "

SRC_URI[md5sum] = "6e5c668473c57906bdec1c641bac4579"
SRC_URI[sha256sum] = "871e86b7e989de0c1224ac7ab8ed6d8b52756cf793a8c253b56ab8ba8d288c96"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "wpebackend (< 1.0) wpebackend-fdo (< 1.0)"
