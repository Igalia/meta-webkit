require webkitgtk.inc

DEPENDS += " libgcrypt"

SRC_URI = "\
   https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
   file://CFLAGS-from-pkg-config-for-EGL-are-not-passed-to-WebKit2.patch \
"

SRC_URI[md5sum] = "0e2d142a586e4ff79cf0324f4fdbf20c"
SRC_URI[sha256sum] = "fc23650df953123c59b9c0edf3855e7bd55bd107820997fc72375811e1ea4b21"
