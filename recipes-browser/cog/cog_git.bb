require cog.inc

DEFAULT_PREFERENCE = "-1"

PV = "git${AUTOREV}"
SRCREV = "${AUTOREV}"
SRC_URI = " git://github.com/Igalia/cog.git;protocol=https;branch=master"
S = "${WORKDIR}/git"
