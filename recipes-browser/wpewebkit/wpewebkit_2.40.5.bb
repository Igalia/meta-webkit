require wpewebkit.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-FELightningNEON.cpp-fails-to-build-NEON-fast-path-se.patch \
           file://0001-WPE-Fix-build-without-USE_GBM.patch \
          "

SRC_URI[tarball.sha256sum] = "4c658d3049c50e98b12fd6623ec42772f25a99cc1c05b5347a10a8633c266733"

DEPENDS += " libwpe"

# temporarily enable WPE API 1.1 for cog 0.16
PACKAGECONFIG:append = " wpe-1-1-api"

