HOMEPAGE = "https://github.com/flatpak/xdg-dbus-proxy"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = " \
    git://git@github.com/flatpak/xdg-dbus-proxy;protocol=https \
"
SRCREV = "7ebcc6856c6a1ee9571fa19c45999e86d44d3e5b"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

BBCLASSEXTEND = "native"
