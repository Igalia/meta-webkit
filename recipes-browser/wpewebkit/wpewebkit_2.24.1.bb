require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz \
          "

SRC_URI[md5sum] = "0f7b792874853416d8005b020bd90685"
SRC_URI[sha256sum] = "95f2fb68429fbd901ea415d09fdd88d6d9ac5ec2d170bec9977093b12e5093a6"

DEPENDS += " libwpe"
