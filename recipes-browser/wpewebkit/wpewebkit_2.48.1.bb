require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball"

SRC_URI[tarball.sha256sum] = "2f411b692bb4c2a924d9bddf0c794fd69a24931ad836d6a93c9a65f5adb0357f"

SRCBRANCH:class-devupstream = "webkitglib/2.48"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "80fc85dcfbc994e312c3ba307019549e209354c6"

# Experimental new WPE platform API
PACKAGECONFIG[experimental-wpe-platform] = "-DENABLE_WPE_PLATFORM=ON,-DENABLE_WPE_PLATFORM=OFF,libinput wayland-native"

PACKAGECONFIG:append= " gpu-process"

FILES:${PN}-web-inspector-plugin += "${datadir}/wpe-webkit-*/inspector.gresource"

EXTRA_OECMAKE += "-DUSE_SYSTEM_SYSPROF_CAPTURE=OFF"
