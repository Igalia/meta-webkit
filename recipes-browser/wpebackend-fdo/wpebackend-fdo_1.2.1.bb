require wpebackend-fdo.inc

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "fc76ac572ed03da8237d1e3e3991d0c3"
SRC_URI[sha256sum] = "6ef0852ecb9513a6789f8bbb9533083fcb165bb2d762eeb6d31e0b58c708cca0"

S = "${WORKDIR}/${PN}-${PV}"

DEPENDS += " libwpe"
