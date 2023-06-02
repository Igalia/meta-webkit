require cog.inc
require cog-meson.inc
require conf/include/devupstream.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI[sha256sum] = "beb98996c48927e7283961877d45acb7f26ed71d78be9c4984fbff30ed0bedb7"

SRC_URI:class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;tag=0.17.90;nobranch=1"
SRCREV:class-devupstream = "0.17.90"

# Required since https://github.com/Igalia/cog/commit/48dfac2ba637e223eeea1b289526d0f51e39ab88
DEPENDS:append = " libxkbcommon"

RDEPENDS:${PN} += "wpewebkit (>= 2.38)"

# Required for 0.17+
PACKAGECONFIG[soup2] = ",,libsoup-2.4"
