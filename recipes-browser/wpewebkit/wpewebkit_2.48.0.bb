require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball"

SRC_URI[tarball.sha256sum] = "25bc557fd62f06ac8393a6f638ffceff3d9f367d6d35195315fa459c82f80850"

SRCBRANCH:class-devupstream = "webkitglib/2.48"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "85311593ef3daddfa6dff95ad8f37095389eb25c"

# Experimental new WPE platform API
PACKAGECONFIG[experimental-wpe-platform] = "-DENABLE_WPE_PLATFORM=ON,-DENABLE_WPE_PLATFORM=OFF,libinput wayland-native"

PACKAGECONFIG:append= " gpu-process"

FILES:${PN}-web-inspector-plugin += "${datadir}/wpe-webkit-*/inspector.gresource"

EXTRA_OECMAKE += "-DUSE_SYSTEM_SYSPROF_CAPTURE=OFF"
