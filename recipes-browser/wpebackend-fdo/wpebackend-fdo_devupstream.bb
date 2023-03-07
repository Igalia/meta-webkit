require wpebackend-fdo.inc
require conf/include/devupstream.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master"
SRCREV = "f2901c6ed7f720a578bfd5830d12426c979c0afa"
S = "${WORKDIR}/git"
