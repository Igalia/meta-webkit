require webkitgtk.inc

SRC_URI = "\
   http://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
"

SRC_URI[md5sum] = "910749295bd17738469ae19ec9dded24"
SRC_URI[sha256sum] = "bbb18d741780b1b7fa284beb9a97361ac57cda2e42bad2ae2fcdbf797919e969"

PACKAGECONFIG[libsecret] = "-DENABLE_CREDENTIAL_STORAGE=ON,-DENABLE_CREDENTIAL_STORAGE=OFF,libsecret"
