SUMMARY = "Basic on-screen keyboard using gtkmm, virtual-keyboard-v1 and layer-shell protocols"
HOMEPAGE = "https://github.com/WayfireWM/wf-osk"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cbc855653223ef4dc1183e61d6f02318"
DEPENDS = "gtk-layer-shell gtkmm3 wayland-native"
REQUIRED_DISTRO_FEATURES = "wayland"

SRCREV = "d2e2e3228913ffa800ca31402820d2d90619279e"
SRC_URI = "git://github.com/WayfireWM/wf-osk;protocol=https"
S = "${WORKDIR}/git"

inherit meson pkgconfig features_check
