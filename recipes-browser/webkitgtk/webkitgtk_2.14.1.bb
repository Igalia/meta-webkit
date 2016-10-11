require webkitgtk.inc

DEPENDS += " gnutls"

SRC_URI = "\
   https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
"

SRC_URI[md5sum] = "8d6c60dc41604d3bbd43165a674c07e5"
SRC_URI[sha256sum] = "2e2d76c328de65bed6e0e4f096b2720a366654b27fc1af0830ece90bc4b7ceb5"
