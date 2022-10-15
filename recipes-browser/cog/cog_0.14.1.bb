require cog.inc
require cog-cmake.inc

SRC_URI[sha256sum] = "fb91104e25e1dde27189c91c70acc356e387f47acebaa8997e01ce5879c3a600"

# Required since https://github.com/Igalia/cog/commit/48dfac2ba637e223eeea1b289526d0f51e39ab88
DEPENDS:append = " libxkbcommon"

RDEPENDS:${PN} += "wpewebkit (>= 2.36)"

PACKAGECONFIG[soup2] = "-DUSE_SOUP2=ON,-DUSE_SOUP2=OFF,libsoup-2.4"

# libsoup-3 is not available before Poky kirkstone.
# http://git.yoctoproject.org/cgit/cgit.cgi/poky/commit/meta/recipes-support/libsoup/libsoup_3.0.1.bb?id=de296e2b2be876ca5cf2af309b710111e2b2581e
PACKAGECONFIG:append = " ${@bb.utils.contains_any('LAYERSERIES_CORENAMES', 'dunfell gatesgarth hardknott honister', 'soup2', '', d)}"

