require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-JSC-Fix-build-failure-on-musl-Add-fallback-for-round.patch \
          "

SRC_URI[tarball.sha256sum] = "1e0aaf870f36001c42b1ce5a2027b4101bed878746e437cc6d6fed0693afe9ad"

SRCBRANCH:class-devupstream = "webkitglib/2.46"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "eacf9977760d4ea5dfcb736be73ae48c7df16f27"

# Experimental new WPE platform API
PACKAGECONFIG[experimental-wpe-platform] = "-DENABLE_WPE_PLATFORM=ON,-DENABLE_WPE_PLATFORM=OFF,libinput"

EXTRA_OECMAKE += "-DUSE_SYSTEM_SYSPROF_CAPTURE=OFF"
