require wpebackend-fdo.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[md5sum] = "c6362491a4a38ddac42b66f140e1cff2"
SRC_URI[sha256sum] = "6249a0b7cbfa662206a8d2fa24e2c574e75c681ad0e93468091f1dc68ddb299d"

S = "${WORKDIR}/${BPN}-${PV}"
