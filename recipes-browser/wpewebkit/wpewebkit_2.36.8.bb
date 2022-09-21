require wpewebkit.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-Fix-include-path-gstreamer-on-cross-toolchain.patch \
           "

SRC_URI[tarball.sha256sum] = "8d42a349c910b2d0961b8d34fecef29cec3d21e3af5977346c90026692dc75eb"

DEPENDS += " libwpe"
RCONFLICTS:${PN} = "libwpe (>= 1.14) wpebackend-fdo (>= 1.14)"

