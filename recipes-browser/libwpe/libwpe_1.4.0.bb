require libwpe.inc

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=371a616eb4903c6cb79e9893a5f615cc"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[md5sum] = "4b6dbaa2d40408975fe1be935367b4e8"
SRC_URI[sha256sum] = "e2d3494fc33fe946ad917fd6a3abd127462b91bba62ef8b35507e92f8ede4188"

BBCLASSEXTEND += "devupstream:target"

SRC_URI_class-devupstream = "git://github.com/WebPlatformForEmbedded/libwpe.git;protocol=https;branch=master"
SRCREV_class-devupstream = "67ccb407efb295c727553145080937e8bb3a3211"

S = "${WORKDIR}/${BPN}-${PV}"
