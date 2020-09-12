require wpewebkit.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"

SRC_URI[sha256sum] = "785d83b99cd45cedb7c4f1f697db773a5a81eb0a42aeeafa3c623053f6fde87a"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.4) wpebackend-fdo (< 1.4)"

