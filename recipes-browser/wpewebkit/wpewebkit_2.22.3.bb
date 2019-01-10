require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz \
           file://0001-REGRESSION-r217927-WPE-2.22-GSTREAMER_GL-Video-appea.patch \
          "

SRC_URI[md5sum] = "6d0c693ea49a93fc9e701cf784245ea5"
SRC_URI[sha256sum] = "241f177cded1a4ba3088716650eaaac25588878882170789b3c630ac45dbb2fa"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "wpebackend (< 1.0) wpebackend-fdo (< 1.0)"
