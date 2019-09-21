require cog.inc

SRC_URI = "https://github.com/Igalia/cog/releases/download/v${PV}/cog-${PV}.tar.xz"

SRC_URI[md5sum] = "75a0838ee6c81bb8df1b254f525440a6"
SRC_URI[sha256sum] = "e9c13a51232434b7340a419b1e6f59c40c582cd80c8e60bd9ec7de16c904fc03"

RDEPENDS_${PN} = "wpewebkit (>= 2.24)"
