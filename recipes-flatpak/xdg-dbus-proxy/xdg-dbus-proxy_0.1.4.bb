HOMEPAGE = "https://github.com/flatpak/xdg-dbus-proxy"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

DEPENDS = "glib-2.0"

SRC_URI = "https://github.com/flatpak/${BPN}/releases/download/${PV}/${BP}.tar.xz"
SRC_URI[sha256sum] = "1ec0eab53d1e49966d722352bcfd51ac402dce5190baedc749a8541e761670ab"

inherit meson pkgconfig

EXTRA_OEMESON += "-Dman=disabled -Dtests=false"
