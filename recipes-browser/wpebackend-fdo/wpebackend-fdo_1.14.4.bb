require wpebackend-fdo.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "d0edbd8f1850f5eb179bfa675db79d91b6f9ee8c8f94694a449e3cd975763410"

SRCBRANCH:class-devupstream ?= "wpebackend-fdo-1.14"
SRC_URI:class-devupstream = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "b61725fe2dd523e99dbc2b81b23b298043540727"

