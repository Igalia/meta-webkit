require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0003-WPE-Platform-fix-wpe_toplevel_qtquick-has-not-been-d.patch \
           file://0004-WPE-Platform-fix-wpe_view_resize-was-not-declared-is.patch \
           file://0005-WPEPlatform-Input-methods-do-not-work.patch \
           file://0006-WPE-GTK-Build-fixes-for-gbm-disabled-and-release-log.patch \
           file://0007-Unreviewed-reverting-292-webkitglib-2.46-cdbaf316924.patch \
           "

SRC_URI[tarball.sha256sum] = "a22f6acf5574f9415f5007c6e79c5f8527363d1ae1dbd8d786e67a935ef56d8b"

SRCBRANCH:class-devupstream = "webkitglib/2.46"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "78876f5eb2a3c15decf20b3f4c5610e67850f74a"

# Experimental new WPE platform API
PACKAGECONFIG[experimental-wpe-platform] = "-DENABLE_WPE_PLATFORM=ON,-DENABLE_WPE_PLATFORM=OFF,libinput wayland-native"

EXTRA_OECMAKE += "-DUSE_SYSTEM_SYSPROF_CAPTURE=OFF"
