HOMEPAGE = "https://github.com/flatpak/xdg-dbus-proxy"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/LGPL-2.1;md5=1a6d268fd218675ffea8be556788b780"

SRC_URI = "https://github.com/flatpak/${PN}/releases/download/${PV}/${BPN}-${PV}.tar.xz"
SRC_URI[md5sum] = "26cc219cf9020ee20fc796427bf4beef"
SRC_URI[sha256sum] = "9eefd30fe66940c8daf0e8ce6479307694814edb8b636caeb5aa6d6a46a4bc14"

inherit autotools pkgconfig gobject-introspection

EXTRA_OECONF_remove = "--enable-introspection"
EXTRA_OECONF_remove = "--disable-introspection"

BBCLASSEXTEND = "native"
