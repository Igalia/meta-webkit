require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "3604a2167827c8354f6dcbab98305d7b"
SRC_URI[sha256sum] = "cf251a467b3bcae50f97e22f4baccca49fcbbd54162dc5b71c0b1ebf655fd95f"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.2) wpebackend-fdo (< 1.2)"
