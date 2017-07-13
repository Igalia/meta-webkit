require webkitgtk.inc

DEPENDS += " gnutls"

SRC_URI = "\
   https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
"

SRC_URI[md5sum] = "2fe3cadbc546d93ca68a13756c2be015"
SRC_URI[sha256sum] = "2edbcbd5105046aea55af9671c4de8deedb5b0e3567c618034d440a760675556"

PACKAGECONFIG[libsecret] = "-DENABLE_CREDENTIAL_STORAGE=ON,-DENABLE_CREDENTIAL_STORAGE=OFF,libsecret"
