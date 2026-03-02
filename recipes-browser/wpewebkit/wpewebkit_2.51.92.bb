require wpewebkit.inc
require conf/include/devupstream.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball"

SRC_URI[tarball.sha256sum] = "e8a08dc219311c34845db527b49e52368f351546081b910e1d900aa081ba3f60"

SRCBRANCH:class-devupstream = "webkitglib/2.52"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "ed00b3221802c01e063ae206cbda484103b461de"
