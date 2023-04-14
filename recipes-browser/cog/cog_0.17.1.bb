require cog.inc
require cog-meson.inc
require conf/include/devupstream.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI[sha256sum] = "69e7d3b62c206210c3c436746d1241bfb99a1e789e6c4b7cb65dd9ae72459d42"

SRC_URI:class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;tag=0.17.1"
SRCREV:class-devupstream = "0.17.1"

# Required since https://github.com/Igalia/cog/commit/48dfac2ba637e223eeea1b289526d0f51e39ab88
DEPENDS:append = " libxkbcommon"

RDEPENDS:${PN} += "wpewebkit (>= 2.38)"

# Required for 0.17+
PACKAGECONFIG[soup2] = ",,libsoup-2.4"
