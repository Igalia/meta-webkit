require cog.inc

PV = "git${AUTOREV}"
SRCREV = "${AUTOREV}"
SRC_URI = " git://github.com/Igalia/cog.git;protocol=https;branch=master"
S = "${WORKDIR}/git"

DEFAULT_PREFERENCE = "-1"
