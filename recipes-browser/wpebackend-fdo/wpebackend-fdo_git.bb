require wpebackend-fdo.inc

DEFAULT_PRERENCE = "-1"
PV = "0.1~git"

# This version of WPEBackend-fdo is not selected by default on this layer,
# as the released versions is preferred.
# To select it, add on your local.conf conf file the line below:
#
# PREFERRED_VERSION_wpebackend-fdo = "0.1~git%"

SRCREV = "76079c1809a5319da9d0cf9bbdb86ee0a44f55d0"
SRC_URI = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master"

S = "${WORKDIR}/git"
