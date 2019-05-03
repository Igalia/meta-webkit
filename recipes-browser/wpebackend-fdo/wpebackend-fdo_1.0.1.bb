require wpebackend-fdo.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI += "file://PKG_CONFIG_SYSROOT_DIR_for_wayland_scanner.patch"
SRC_URI[md5sum] = "2ee81a4212c18110a06a0c51c12e0d2e"
SRC_URI[sha256sum] = "15b8b1febea5d9c271e95c35b3c1e13f870712a54bc5f689cfdbb96e2f070fc8"

S = "${WORKDIR}/${PN}-${PV}"

DEPENDS += " libwpe"
