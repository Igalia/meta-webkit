require cog.inc
require cog-meson.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI[sha256sum] = "72e3a84052b459e2d53d0e8b947f20e27bf5d8049766c4c1594eb9c6b6cf7ab3"

# Required since https://github.com/Igalia/cog/commit/48dfac2ba637e223eeea1b289526d0f51e39ab88
DEPENDS:append = " libxkbcommon"

RDEPENDS:${PN} += "wpewebkit (>= 2.36)"
