require libwpe.inc
require libwpe-pkg.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "c7f3a3c6b3d006790d486dc7cceda2b6d2e329de07f33bc47dfc53f00f334b2a"

SRCBRANCH:class-devupstream ?= "libwpe-1.16"
SRC_URI:class-devupstream = "git://github.com/WebPlatformForEmbedded/libwpe.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "782026ce4976a35e9343ba75aefe379b0d8428f7"

