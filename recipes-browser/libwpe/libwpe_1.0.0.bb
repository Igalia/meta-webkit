require libwpe.inc

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "b5ea32bd644811d5c6433cf1439763f7"
SRC_URI[sha256sum] = "aff11612123f9ab85a8b9a4bcdfb3a7503eba0a0d2d96f2cdecd30e911091719"

S = "${WORKDIR}/${PN}-${PV}"
