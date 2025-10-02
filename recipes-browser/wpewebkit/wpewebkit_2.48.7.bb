require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-Enforce-surface-size-match-when-maximized-to-avoid-W.patch \
          "

SRC_URI[tarball.sha256sum] = "cecf49844dfba7ccf53d64b32cb8cf2cbd69eb5ec9080b1c6e52f9d1ee87b690"

SRCBRANCH:class-devupstream = "webkitglib/2.48"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "8f7f470b41951ad4b90a633338aa57ddaa768c92"

# Experimental new WPE platform API
PACKAGECONFIG[experimental-wpe-platform] = "-DENABLE_WPE_PLATFORM=ON,-DENABLE_WPE_PLATFORM=OFF,libinput wayland-native"

PACKAGECONFIG:append= " gpu-process"

FILES:${PN}-web-inspector-plugin += "${datadir}/wpe-webkit-*/inspector.gresource"

EXTRA_OECMAKE += "-DUSE_SYSTEM_SYSPROF_CAPTURE=OFF"
