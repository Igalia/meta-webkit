require libwpe.inc
require conf/include/devupstream.inc

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=371a616eb4903c6cb79e9893a5f615cc"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "3587c6b8a807f4bb76b268ba74ca82c6b395b90235db41ad8252224456193c90"

SRC_URI_class-devupstream = "git://github.com/WebPlatformForEmbedded/libwpe.git;protocol=https;branch=master"
SRCREV_class-devupstream = "617dc7ae908bc72fc43476feb58ab7fe1f9c83cd"

