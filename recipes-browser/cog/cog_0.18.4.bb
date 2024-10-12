require cog.inc
require cog-meson.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "31d7079db2eeed790899d2f1f824dd6a54bf30d072d196d737be572f105d99b1"

SRC_URI:class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=master"
# Cog 0.18.X branch was forked from the master branch in this commit
SRCREV:class-devupstream = "8e1acd3704e22904acc2fee0d4a2f5344257434c"

RDEPENDS:${PN} += "wpewebkit (>= 2.42)"

