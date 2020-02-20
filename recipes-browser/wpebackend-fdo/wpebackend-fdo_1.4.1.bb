require wpebackend-fdo.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[md5sum] = "c6362491a4a38ddac42b66f140e1cff2"
SRC_URI[sha256sum] = "6249a0b7cbfa662206a8d2fa24e2c574e75c681ad0e93468091f1dc68ddb299d"

BBCLASSEXTEND += "devupstream:target"

SRC_URI_class-devupstream = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master"
SRCREV_class-devupstream = "b01aa039d1fea67bb0a45cb00d88d28f707c96bb"

S = "${WORKDIR}/${BPN}-${PV}"

DEPENDS += " libwpe"
