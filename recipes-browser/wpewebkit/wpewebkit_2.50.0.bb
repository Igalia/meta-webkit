require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-Cherry-pick-300316-main-2b754f0fec28-.-https-bugs.we.patch \
           file://0002-Cherry-pick-300315-main-79a0cf9b1bef-.-https-bugs.we.patch \
           file://0003-Cherry-pick-300185-main-f0d8991bbfe3-.-https-bugs.we.patch \
          "

SRC_URI[tarball.sha256sum] = "a9af62c5e18551b7386b7db864e8ba8156f219b8e6c639934bf6f3a567969922"

SRCBRANCH:class-devupstream = "webkitglib/2.50"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "eef2adcc65cf91d1c97ccc9f5ca6b2d87774f16a"

PACKAGECONFIG[mediastream] = "-DENABLE_MEDIA_STREAM=ON,-DENABLE_MEDIA_STREAM=OFF,gstreamer1.0 gstreamer1.0-plugins-bad"

# Enable WPE platform API
PACKAGECONFIG[wpe-platform] = "-DENABLE_WPE_PLATFORM=ON,-DENABLE_WPE_PLATFORM=OFF,libinput wayland-native"
