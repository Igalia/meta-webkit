require libwpe.inc

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=371a616eb4903c6cb79e9893a5f615cc"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[md5sum] = "1d4d38413ee0d0043f74d0445cab906f"
SRC_URI[sha256sum] = "09849dfb34877354f34f318e138971cf22e677b2179e1f0a8ea00ab0b7bd8e9b"

BBCLASSEXTEND += "devupstream:target"

SRC_URI_class-devupstream = "git://github.com/WebPlatformForEmbedded/libwpe.git;protocol=https;branch=master"
SRCREV_class-devupstream = "b191f14936a64ae0685f50ce2bb22f7c50bf156d"

S = "${WORKDIR}/${BPN}-${PV}"
