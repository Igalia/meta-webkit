require wpebackend-fdo.inc
require conf/include/devupstream.inc

# wpebackend-fdo uses meson since (not branched yet)
#   https://github.com/Igalia/WPEBackend-fdo/commit/9c13d73bcc3726e2290c182d76d67b384f4c1318
inherit meson

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master"
SRCREV = "99bd04019800f84a722ae99bf1a352f225d93002"
S = "${WORKDIR}/git"
