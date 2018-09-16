require wpebackend.inc

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "d04e44a32709dbb763ce1fcfc28bc6d8"
SRC_URI[sha256sum] = "ce33ff29b04175cb6fe6e6597a4b5e8ec9da0b8b5ae0745848902ac935d65823"

S = "${WORKDIR}/${PN}-${PV}"
