require cog.inc
require conf/include/devupstream.inc

SRC_URI = "https://github.com/Igalia/cog/releases/download/v${PV}/cog-${PV}.tar.xz"

SRC_URI[sha256sum] = "3bb940741b685e89305decc894acf0b4ed9fdc77f7878b70da48a1def2e71925"

SRC_URI_class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=master"
SRCREV_class-devupstream = "e70c864cec3eb125ea6797d097da1aca88099da0"

RDEPENDS_${PN} += "wpewebkit (>= 2.28)"
