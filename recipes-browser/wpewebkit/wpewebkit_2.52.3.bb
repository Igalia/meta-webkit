require wpewebkit.inc
require conf/include/devupstream.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball"

SRC_URI[tarball.sha256sum] = "b51b1db1e6ee99d1771f4a358c128fde27a77984df20ee6cb59858e520662d0b"

SRCBRANCH:class-devupstream = "webkitglib/2.52"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "5b58d7028bf6200b044538a98fd0963c70837eae"
