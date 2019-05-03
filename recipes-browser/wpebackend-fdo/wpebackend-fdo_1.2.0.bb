require wpebackend-fdo.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI += "file://PKG_CONFIG_SYSROOT_DIR_for_wayland_scanner.patch"
SRC_URI[md5sum] = "74e1b2fc2bc19933b17ff4f8435f67cd"
SRC_URI[sha256sum] = "b1bb261273772af8f7d96d94989fc2ed0445ec06c7eb21f47a1b94e52422ddd5"

S = "${WORKDIR}/${PN}-${PV}"

DEPENDS += " libwpe"
