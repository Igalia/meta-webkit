require wpewebkit.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-Fix-include-path-gstreamer-on-cross-toolchain.patch \
           "

SRC_URI[tarball.sha256sum] = "f3747d72ffc562ad0cfb6218fdf6d897c78c4bdbf5618e0fa26906fba52b95c9"

DEPENDS += " libwpe"
RCONFLICTS:${PN} = "libwpe (< 1.10) wpebackend-fdo (< 1.10)"

# Needed from 2.36
PACKAGECONFIG[journald] = "-DENABLE_JOURNALD_LOG=ON,-DENABLE_JOURNALD_LOG=OFF,"
PACKAGECONFIG:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'journald', '' ,d)}"

