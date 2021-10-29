require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
"

SRC_URI[tarball.sha256sum] = "381f1422cbc319db1aa42dda48de39590ed90ac3bec6b81ec83f3f2cae5c3eeb"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.6) wpebackend-fdo (< 1.8)"

PACKAGECONFIG[indexeddb] = "-DENABLE_INDEXED_DATABASE=ON,-DENABLE_INDEXED_DATABASE=OFF,"

PACKAGECONFIG_append = " indexeddb"
