require wpewebkit.inc
require conf/include/devupstream.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball"

SRC_URI[tarball.sha256sum] = "b2bafef2751625b7fdf530f230ff0f542ff0eeba3590c3a989d931b2a55c858e"

SRCBRANCH:class-devupstream = "webkitglib/2.52"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "9d13dd1044b113a8cd37bd86774056a240482cc8"
