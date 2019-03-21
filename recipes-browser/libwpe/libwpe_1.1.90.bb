require libwpe.inc

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "fa2498919b3d3bc0d0a9aaff601e9628"
SRC_URI[sha256sum] = "d21dcf83f7e7405e8296c1732d240637d2facdb40e1c9879a1c0f9f222517592"

S = "${WORKDIR}/${PN}-${PV}"
