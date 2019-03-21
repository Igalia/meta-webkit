require wpebackend-fdo.inc

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "32a2a789188d300075b87bb3af967593"
SRC_URI[sha256sum] = "d20e5688e3e6d9fdf1c3ee083ea14720bf59354aa17f275a003b030e8131315d"

S = "${WORKDIR}/${PN}-${PV}"

FILES_${PN} += "${libdir}/libWPEBackend-fdo-1.0.so"

DEPENDS += " libwpe"
