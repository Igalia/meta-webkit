require wpewebkit.inc
require conf/include/devupstream.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball"

SRC_URI[tarball.sha256sum] = "bcfc6c91db7659dcf24f6ff79ad27ac1eae1bc61dca0dbfee154706926740b3b"

SRCBRANCH:class-devupstream = "webkitglib/2.52"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "9d11fa1a37e61a75d8167ee4bc1a8e7604aff408"
