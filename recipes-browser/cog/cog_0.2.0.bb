require cog.inc

SRC_URI = "https://github.com/Igalia/${PN}/archive/v${PV}.tar.gz"

SRC_URI[md5sum] = "3161a6260cb95f273cebf598bb3fcb92"
SRC_URI[sha256sum] = "a6abadb78395226bac2e1dd5467feab2cc8c493eab6894a09a51a8e072e38c06"

RCONFLICTS_${PN} = "wpewebkit (>= 2.23)"
