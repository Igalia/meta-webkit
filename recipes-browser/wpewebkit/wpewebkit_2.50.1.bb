require wpewebkit.inc
require conf/include/devupstream.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball"

SRC_URI[tarball.sha256sum] = "305437a4ba869e4106c1d4a8cb2a7be3f43b75d9d026e9b97c6f6debc04a673b"

SRCBRANCH:class-devupstream = "webkitglib/2.51"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "57de75dc86598c23b276c546b107cc0211632f39"
