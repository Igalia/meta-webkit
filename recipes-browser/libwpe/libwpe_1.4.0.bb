require libwpe.inc

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=371a616eb4903c6cb79e9893a5f615cc"

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "4b6dbaa2d40408975fe1be935367b4e8"
SRC_URI[sha256sum] = "e2d3494fc33fe946ad917fd6a3abd127462b91bba62ef8b35507e92f8ede4188"

S = "${WORKDIR}/${PN}-${PV}"
