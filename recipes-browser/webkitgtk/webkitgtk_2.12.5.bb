require webkitgtk.inc

SRC_URI = "\
   https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
   file://0001-WebKitMacros-Append-to-I-and-not-to-isystem.patch \
"

SRC_URI[md5sum] = "7a9ea00ec195488db90fdeb2d174ddaf"
SRC_URI[sha256sum] = "6b147854b864a5f115fadb97b2b6200b2f696db015216a34e7298d11c88b1c40"

PACKAGECONFIG[libsecret] = "-DENABLE_CREDENTIAL_STORAGE=ON,-DENABLE_CREDENTIAL_STORAGE=OFF,libsecret"
