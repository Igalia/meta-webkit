require wpebackend-fdo.inc
require conf/include/devupstream.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master"
SRCREV = "c99b7b9316eaf80971799404dd7ad5c87f70a42f"
S = "${WORKDIR}/git"
