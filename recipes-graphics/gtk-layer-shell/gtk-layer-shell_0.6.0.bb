SUMMARY = "Library to create Wayland desktop components using the Layer Shell protocol"
HOMEPAGE = "https://github.com/wmww/gtk-layer-shell"
BUGTRACKER = "https://github.com/wmww/gtk-layer-shell/issues"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE_LGPL.txt;md5=3000208d539ec061b899bce1d9ce9404"
DEPENDS = "gtk+3 wlroots wayland-native"
REQUIRED_DISTRO_FEATURES = "wayland"
SRCREV = "eac78939e3ea07b119a57488e6645a6cd5d7eafd"
SRC_URI = "git://github.com/wmww/${BPN}.git;protocol=https"
S = "${WORKDIR}/git"

inherit meson pkgconfig features_check gobject-introspection
