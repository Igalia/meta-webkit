require libwpe.inc

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=6ae4db0d4b812334e1539cd5aa6e2f46"

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "b5ea32bd644811d5c6433cf1439763f7"
SRC_URI[sha256sum] = "aff11612123f9ab85a8b9a4bcdfb3a7503eba0a0d2d96f2cdecd30e911091719"

S = "${WORKDIR}/${PN}-${PV}"
