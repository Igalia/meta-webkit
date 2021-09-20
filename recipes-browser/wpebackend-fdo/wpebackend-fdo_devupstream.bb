require wpebackend-fdo.inc
require conf/include/devupstream.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master"
SRCREV = "99bd04019800f84a722ae99bf1a352f225d93002"
S = "${WORKDIR}/git"
