require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "057cc2647231e90c8197873df9a9f54c"
SRC_URI[sha256sum] = "dd4fce390f1721d8d6d017fa712adb990f7230bde84a1b7d27327bd589053fdd"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.2) wpebackend-fdo (< 1.2)"
