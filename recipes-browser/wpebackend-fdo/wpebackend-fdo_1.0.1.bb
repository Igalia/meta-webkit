require wpebackend-fdo.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[md5sum] = "2ee81a4212c18110a06a0c51c12e0d2e"
SRC_URI[sha256sum] = "15b8b1febea5d9c271e95c35b3c1e13f870712a54bc5f689cfdbb96e2f070fc8"

S = "${WORKDIR}/${BPN}-${PV}"

DEPENDS += " libwpe"
