require wpebackend-fdo.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "7f5bd7b9d8f97b1655f4dcd39fad92719d0fb3985b251da5802df13aaa09f567"

BBCLASSEXTEND += "devupstream:target"

SRC_URI_class-devupstream = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master"
SRCREV_class-devupstream = "5b4fa3cf160c957589a06d3b99589e53cccb0ee1"

DEPENDS += " libwpe"
