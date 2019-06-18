require libwpe.inc

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "ddc2638caa0b922eb6d36ee15080cfdb"
SRC_URI[sha256sum] = "5d5e23ce48b35278201b3b88e5b1a89bd54b38391721b4e74ce472c3905df8b0"

S = "${WORKDIR}/${PN}-${PV}"
