require wpebackend-fdo.inc

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "5318728afb3bf7417293af67ce427963"
SRC_URI[sha256sum] = "7a747f87a1ae46d30144369050e3ce348b58986d04e1a139ba75c198fa636729"

S = "${WORKDIR}/${PN}-${PV}"

DEPENDS += " libwpe"