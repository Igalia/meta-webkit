require cog.inc
require cog-cmake.inc

SRC_URI:append = " file://0001-Fix-missing-xkbcommon.h-include.patch"
SRC_URI[sha256sum] = "9983c621c8e14fca3792ff566cb6b86d6a1f17446eb4c083af4a5a749112982f"

RDEPENDS:${PN} += "wpewebkit (>= 2.34)"

# Releases <0.14 depend on libsoup 2.4
DEPENDS += "libsoup-2.4"

