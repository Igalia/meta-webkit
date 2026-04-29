require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "git://github.com/WebKit/WebKit;protocol=https;branch=webkitglib/2.48 \
           file://0001-Fix-compilation-with-gcc11.patch \
           file://0001-Enforce-surface-size-match-when-maximized-to-avoid-W.patch \
           file://0001-Fix-CSSValue-errors-on-GCC-11.patch \
           "

S = "${WORKDIR}/git"
SRCREV = "903d8d39743fb20f007059f63235b7ad18c44c4d"

SRCBRANCH:class-devupstream = "webkitglib/2.48"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "903d8d39743fb20f007059f63235b7ad18c44c4d"

# Experimental new WPE platform API
PACKAGECONFIG[experimental-wpe-platform] = "-DENABLE_WPE_PLATFORM=ON,-DENABLE_WPE_PLATFORM=OFF,libinput wayland-native"

PACKAGECONFIG:append= " gpu-process"

FILES:${PN}-web-inspector-plugin += "${datadir}/wpe-webkit-*/inspector.gresource"

EXTRA_OECMAKE += " -DUSE_SYSTEM_SYSPROF_CAPTURE=OFF -DENABLE_COG=OFF"
