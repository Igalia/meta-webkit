require cog.inc
require cog-meson.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "0ede9d09ab635ac519beec0543378e3fc51b56561a5fb7aa9c0cbca54c31b97c"

SRCBRANCH:class-devupstream ?= "cog-0.18"
SRC_URI:class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "5d7c720e4f16360a0412a949a1a3f4209e81b9ec"

RDEPENDS:${PN} += "wpewebkit (>= 2.42)"

