require wpewebkit.inc
require conf/include/devupstream.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball"

SRC_URI[tarball.sha256sum] = "efa9bcc3cb891c2d88f50eec710d9ccee71cbdf1040420361eb98c17355eb452"

SRCBRANCH:class-devupstream = "webkitglib/2.54"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "73f39d84ea9d4071994214373efbde3665402b05"
