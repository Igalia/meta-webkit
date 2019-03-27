require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz \
          "

SRC_URI[md5sum] = "042848cd0d0f9f7fa54663db8e4751dc"
SRC_URI[sha256sum] = "d2e5e444134720cbad5c8669996000a004943bb71ee6783aefa72a80bde1b35a"

DEPENDS += " libwpe"
