require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-Enforce-surface-size-match-when-maximized-to-avoid-W.patch \
           file://0002-REGRESSION-2.48.5-WPE-GTK-Does-not-compile-on-ARMv7.patch \
          "

SRC_URI[tarball.sha256sum] = "01f36010705adb14404c56baf033147f7927cc7c6badec81bb141266fcdd8d0b"

SRCBRANCH:class-devupstream = "webkitglib/2.48"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "8f7f470b41951ad4b90a633338aa57ddaa768c92"

# Experimental new WPE platform API
PACKAGECONFIG[experimental-wpe-platform] = "-DENABLE_WPE_PLATFORM=ON,-DENABLE_WPE_PLATFORM=OFF,libinput wayland-native"

PACKAGECONFIG:append= " gpu-process"

FILES:${PN}-web-inspector-plugin += "${datadir}/wpe-webkit-*/inspector.gresource"

EXTRA_OECMAKE += "-DUSE_SYSTEM_SYSPROF_CAPTURE=OFF"
