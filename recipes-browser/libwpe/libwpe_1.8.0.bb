require libwpe.inc
require conf/include/devupstream.inc

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=371a616eb4903c6cb79e9893a5f615cc"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "a6f00a7d091cbd4db57fe7ee3b4c12c6350921d654ed79812800a26c888481d2"

SRC_URI_class-devupstream = "git://github.com/WebPlatformForEmbedded/libwpe.git;protocol=https;branch=master"
SRCREV_class-devupstream = "f6362cea233a0d0047a726505d2b2b638906cf09"

