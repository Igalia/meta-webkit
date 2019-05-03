require wpebackend-fdo.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEFAULT_PREFERENCE = "-1"
PV = "1.2.0~git"

# This version of WPEBackend-fdo is not selected by default on this layer,
# as the released versions is preferred.
# To select it, add on your local.conf conf file the line below:
#
# PREFERRED_VERSION_wpebackend-fdo = "1.2.0~git%"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master"
SRC_URI += "file://PKG_CONFIG_SYSROOT_DIR_for_wayland_scanner.patch"

S = "${WORKDIR}/git"

DEPENDS += " libwpe"
