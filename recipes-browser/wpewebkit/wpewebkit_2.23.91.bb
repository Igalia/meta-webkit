require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz \
          "

SRC_URI[md5sum] = "2c823548d9da12b466a8e2fb46c68d52"
SRC_URI[sha256sum] = "23885d07d19e25cd804dc1eda8d14c7ed248fcc0a2268d0a2133d38a2a81ac4b"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "wpebackend (< 1.0) wpebackend-fdo (< 1.0)"
