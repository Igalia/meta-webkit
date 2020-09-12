require cog.inc

SRC_URI = "https://github.com/Igalia/cog/releases/download/v${PV}/cog-${PV}.tar.xz"

SRC_URI[sha256sum] = "208f58e0533b269400875237a95e994c93da7234a29fd1c904e756b88963e35d"

RDEPENDS_${PN} += "wpewebkit (>= 2.28)"
