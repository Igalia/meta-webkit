require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz \
           file://0001-REGRESSION-r217927-WPE-2.22-GSTREAMER_GL-Video-appea.patch \
          "

SRC_URI[md5sum] = "e23753c1b2984303e2523c18031b0736"
SRC_URI[sha256sum] = "625551aa60ad047639cc64be4259f03598c4ed5db5f7427251657f889e822208"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "wpebackend (< 1.0) wpebackend-fdo (< 1.0)"
