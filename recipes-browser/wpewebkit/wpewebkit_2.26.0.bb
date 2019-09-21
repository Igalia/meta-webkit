require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "59a2e64f145b3445187a22eff1f73293"
SRC_URI[sha256sum] = "a97a24fe0c22243c873c359d7636512c01016ea2068a457ba651040f1a07ee3e"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.2) wpebackend-fdo (< 1.2)"
