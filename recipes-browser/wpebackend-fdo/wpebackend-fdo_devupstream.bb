require wpebackend-fdo.inc
require conf/include/devupstream.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master"
SRCREV = "cc6ea928a4d34e6e2199d7a4670d8b8b8261a3bb"
S = "${WORKDIR}/git"
