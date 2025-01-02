require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0003-WPE-Platform-fix-wpe_toplevel_qtquick-has-not-been-d.patch \
           file://0004-WPE-Platform-fix-wpe_view_resize-was-not-declared-is.patch \
           file://0005-WPEPlatform-Input-methods-do-not-work.patch \
           "

SRC_URI[tarball.sha256sum] = "2efd4831efcf86e29546c028d6f17a7b775b61b6499ed62399a00da8f06ea456"

SRCBRANCH:class-devupstream = "webkitglib/2.46"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "43751e1d1959cf0735d155346a408fca80aecadb"

# Experimental new WPE platform API
PACKAGECONFIG[experimental-wpe-platform] = "-DENABLE_WPE_PLATFORM=ON,-DENABLE_WPE_PLATFORM=OFF,libinput wayland-native"

EXTRA_OECMAKE += "-DUSE_SYSTEM_SYSPROF_CAPTURE=OFF"
