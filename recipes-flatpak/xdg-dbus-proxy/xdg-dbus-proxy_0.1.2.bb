HOMEPAGE = "https://github.com/flatpak/xdg-dbus-proxy"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "https://github.com/flatpak/${BPN}/releases/download/${PV}/${BP}.tar.xz \
           file://0001-Call-setlocale.patch \
           file://0001-Fix-musl-compilation-by-adding-TEMP_FAILURE_RETRY.patch \
"
SRC_URI[sha256sum] = "1749d6f9f46dcc9edc87725641cf56cf91dcad1b01707891ea0850c1000c520f"

inherit autotools pkgconfig gobject-introspection

EXTRA_OECONF:remove = "--enable-introspection"
EXTRA_OECONF:remove = "--disable-introspection"

BBCLASSEXTEND = "native"
