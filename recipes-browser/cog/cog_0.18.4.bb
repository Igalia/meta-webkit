require cog.inc
require cog-meson.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "31d7079db2eeed790899d2f1f824dd6a54bf30d072d196d737be572f105d99b1"

SRCBRANCH:class-devupstream ?= "cog-0.18"
SRC_URI:class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "c4625676a21308e7c82175f1ce9a6c8849f22800"

RDEPENDS:${PN} += "wpewebkit (>= 2.42)"

