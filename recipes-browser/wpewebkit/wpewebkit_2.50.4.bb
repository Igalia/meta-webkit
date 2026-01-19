require wpewebkit.inc
require conf/include/devupstream.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball"

SRC_URI[tarball.sha256sum] = "d204e405b0975508748c0273c18090304a979e1170ffa2a0a528fad90191ef87"

SRCBRANCH:class-devupstream = "webkitglib/2.50"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "a0990ac738d2f0440027b9daac74549a441c9afb"
