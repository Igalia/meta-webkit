require wpewebkit.inc
require conf/include/devupstream.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball"

SRC_URI[tarball.sha256sum] = "3adbf9eebec9b7535febb75aca5afa1ea586eaf9b0cdfd3eb56de850fe39ff43"

SRCBRANCH:class-devupstream = "webkitglib/2.52"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "19a3c6b3a65aca2877630c45be9a8bfde110103e"
