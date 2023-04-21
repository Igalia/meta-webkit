require cog.inc
require cog-meson.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI[sha256sum] = "37c5f14123b8dcf077839f6c60f0d721d2a91bb37829e796f420126e6b0d38b5"

# Required since https://github.com/Igalia/cog/commit/48dfac2ba637e223eeea1b289526d0f51e39ab88
DEPENDS:append = " libxkbcommon"

RDEPENDS:${PN} += "wpewebkit (>= 2.36)"

