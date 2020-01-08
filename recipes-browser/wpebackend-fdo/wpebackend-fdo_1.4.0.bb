require wpebackend-fdo.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[md5sum] = "63553c3f43593c2a8c587c32e88fdf3c"
SRC_URI[sha256sum] = "a919ca4a5bc445f9419a5b7f3781cfc98e5abcf5d7259eb1869f5ab20fd18baf"

BBCLASSEXTEND += "devupstream:target"

SRC_URI_class-devupstream = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master"
SRCREV_class-devupstream = "bee4104c897412fbe58da0b9615d3a1a1bde826a"

S = "${WORKDIR}/${BPN}-${PV}"

DEPENDS += " libwpe"
