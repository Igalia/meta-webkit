require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "b5c6fe640b03c3e87594da2c0a0a8469"
SRC_URI[sha256sum] = "907b20907a32a4288cbf67b56eab04cbbd997a7ca0f40b3c466cbbbbfba0e7ca"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.2) wpebackend-fdo (< 1.2)"
