require cog.inc

SRC_URI = "https://github.com/Igalia/${PN}/archive/v${PV}.tar.gz"

SRC_URI[md5sum] = "b2d4fe2fef6ab10a920ab8ee034c2682"
SRC_URI[sha256sum] = "86e760c8dcd021fbc4d7faacf81b90fcd4d8a40e43261be1fbdad0e674f580b6"

RCONFLICTS_${PN} = "wpewebkit (>= 2.21)"
