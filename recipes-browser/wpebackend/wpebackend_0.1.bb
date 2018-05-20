require wpebackend.inc

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "0c4bba4dec2044f087fa119b456a893e"
SRC_URI[sha256sum] = "12261b5819ce64c0eb2b065d9cc2c201c77ddf8bfad31bd8d4e369ce9365ad21"

S = "${WORKDIR}/${PN}-${PV}"
