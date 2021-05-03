require libwpe.inc
require conf/include/devupstream.inc

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=371a616eb4903c6cb79e9893a5f615cc"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "2415e270d45e3595ed4052bc105f733744dc2d3677e12ff4a831e5029841084d"

SRC_URI_class-devupstream = "git://github.com/WebPlatformForEmbedded/libwpe.git;protocol=https;branch=master"
SRCREV_class-devupstream = "4bdc57a8de3675aa0fa4a033f1ac89f792d36b94"

