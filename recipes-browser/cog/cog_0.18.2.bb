require cog.inc
require cog-meson.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "3c4237cff6323b8c3eaf52c6f3f6415b898a22c0127c6c396c1eaa6eef46c279"

SRC_URI:class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=master"
# Cog 0.18.X branch was forked from the master branch in this commit
SRCREV:class-devupstream = "8e1acd3704e22904acc2fee0d4a2f5344257434c"

RDEPENDS:${PN} += "wpewebkit (>= 2.42)"

