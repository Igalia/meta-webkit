require libwpe.inc

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "060876c6a32ef1ae519cb9542d0ede06"
SRC_URI[sha256sum] = "f28035e7a8991fbb1a0e762f1b3d0e3cb57513a3164c75c7dc3eb0c11d9149fc"

S = "${WORKDIR}/${PN}-${PV}"
