require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0003-WPE-Platform-fix-wpe_toplevel_qtquick-has-not-been-d.patch \
           file://0004-WPE-Platform-fix-wpe_view_resize-was-not-declared-is.patch \
           file://0005-WPEPlatform-Input-methods-do-not-work.patch \
           "

SRC_URI[tarball.sha256sum] = "2f8f8447b9c7b0578f7d751ca27c682a2c180b5abb91542af52a96e8a24a6262"

SRCBRANCH:class-devupstream = "webkitglib/2.46"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "2df8c2be6c990bc06d188b606595d9c8fe9e1870"

# Experimental new WPE platform API
PACKAGECONFIG[experimental-wpe-platform] = "-DENABLE_WPE_PLATFORM=ON,-DENABLE_WPE_PLATFORM=OFF,libinput wayland-native"

EXTRA_OECMAKE += "-DUSE_SYSTEM_SYSPROF_CAPTURE=OFF"
