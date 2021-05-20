require cog.inc

SRC_URI = "https://github.com/Igalia/cog/releases/download/v${PV}/cog-${PV}.tar.xz"

SRC_URI[sha256sum] = "b82e917eb764943b9859c631974f8f0e748b79ae87bb7a944f46c818740e0208"

RDEPENDS_${PN} += "wpewebkit (>= 2.28)"

DEFAULT_PREFERENCE = "-1"