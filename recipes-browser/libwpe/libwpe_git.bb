require libwpe.inc

DEFAULT_PREFERENCE = "-1"
PV = "1.3.0~git"

# This version of libwpe is not selected by default on this layer,
# as the released versions is preferred.
# To select it, add on your local.conf conf file the line below:
#
# PREFERRED_VERSION_libwpe = "1.3.0~git%"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/WebPlatformForEmbedded/libwpe.git;protocol=https;branch=master"

S = "${WORKDIR}/git"
