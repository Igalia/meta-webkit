require wpewebkit.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0002-Activate-HAVE_MISSING_STD_FILESYSTEM_PATH_CONSTRUCTO.patch \
          "

SRC_URI[tarball.sha256sum] = "cd6042c63a6f883cc1586e5cea94e846aaaee6a864c14988e8af4ef4f362ba3b"

DEPENDS += " cairo"

