require libwpe.inc
require libwpe-pkg.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "960bdd11c3f2cf5bd91569603ed6d2aa42fd4000ed7cac930a804eac367888d7"

SRCBRANCH:class-devupstream ?= "libwpe-1.16"
SRC_URI:class-devupstream = "git://github.com/WebPlatformForEmbedded/libwpe.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "f9ec67dddde98a89bd0368f6c22e2eec079f36bb"
