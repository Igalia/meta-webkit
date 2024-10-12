require wpebackend-fdo.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "10121842595a850291db3e82f3db0b9984df079022d386ce42c2b8508159dc6c"

SRCBRANCH:class-devupstream ?= "wpebackend-fdo-1.14"
SRC_URI:class-devupstream = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "04ccf2ef1753e72345770fb0a60bf38c5a100de8"

