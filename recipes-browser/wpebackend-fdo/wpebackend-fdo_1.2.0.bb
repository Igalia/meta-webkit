require wpebackend-fdo.inc

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "74e1b2fc2bc19933b17ff4f8435f67cd"
SRC_URI[sha256sum] = "b1bb261273772af8f7d96d94989fc2ed0445ec06c7eb21f47a1b94e52422ddd5"

S = "${WORKDIR}/${PN}-${PV}"

DEPENDS += " libwpe"
