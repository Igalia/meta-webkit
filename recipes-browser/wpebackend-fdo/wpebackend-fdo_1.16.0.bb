require wpebackend-fdo.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "beddf321232d5bd08106c179dbc600f8ce88eb3620b4a59a6329063b78f64635"

SRCBRANCH:class-devupstream ?= "wpebackend-fdo-1.16"
SRC_URI:class-devupstream = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "1d0640439faf233bf35e31bc46ac06b383daa613"

