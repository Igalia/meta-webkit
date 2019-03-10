require cog.inc

SRC_URI = "https://github.com/Igalia/${PN}/archive/v${PV}.tar.gz"

SRC_URI[md5sum] = "2fcb68ae8d52bb4212f9e24724b83f33"
SRC_URI[sha256sum] = "206302966c6019260f5a7a20b4c6afbd4ce77530f7b9cd638fafeed07e47cada"

RCONFLICTS_${PN} = "wpewebkit (>= 2.23)"
