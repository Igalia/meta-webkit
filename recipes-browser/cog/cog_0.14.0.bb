require cog.inc
require conf/include/devupstream.inc

SRC_URI:append = " file://0001-cmake-Fix-CMake-v3.16-cannot-create-ALIAS-target-Wpe.patch"
SRC_URI[sha256sum] = "e23936f1ce350ea5ea6fa0709b63d34776b05709388aed9c6cf3fdc41299de9f"

SRC_URI:class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=cog-0.14"
SRCREV:class-devupstream = "343563b0866bc1802acbbdbb5f163bf9eba5c0ff"

RDEPENDS:${PN} += "wpewebkit (>= 2.36)"

PACKAGECONFIG[soup2] = "-DUSE_SOUP2=ON,-DUSE_SOUP2=OFF,libsoup-2.4"

# libsoup-3 is not available before Poky kirkstone.
# http://git.yoctoproject.org/cgit/cgit.cgi/poky/commit/meta/recipes-support/libsoup/libsoup_3.0.1.bb?id=de296e2b2be876ca5cf2af309b710111e2b2581e
PACKAGECONFIG:append = " ${@bb.utils.contains_any('LAYERSERIES_CORENAMES', 'dunfell gatesgarth hardknott honister', 'soup2', '', d)}"

