require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "bec094fe878e03f42de751cbaf0b3e99"
SRC_URI[sha256sum] = "d1ae85dffb5bfc106c5ac6d5e73a3dfe3cb2c1df1f18c16103e1dc744cd4ac14"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.2) wpebackend-fdo (< 1.2)"
