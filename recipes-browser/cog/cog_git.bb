require cog.inc

# Please: keep PV to the date of the last update, so the version number
# is an always increasing number to avoid "version goes backwards" errors.
PV = "git${AUTOREV}"
SRCREV = "${AUTOREV}"
SRC_URI = " git://github.com/Igalia/cog.git;protocol=https;branch=master"
S = "${WORKDIR}/git"
