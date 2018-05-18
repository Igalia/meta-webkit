require webkitgtk.inc

DEPENDS += " libgcrypt"

SRC_URI = "\
   https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
"

SRC_URI[md5sum] = "af18c2cfa00cadfd0b4d8db21cab011d"
SRC_URI[sha256sum] = "0c6d80cc7eb5d32f8063041fa11a1a6f17a29765c2f69c6bc862cd47c2d539b8"

PACKAGECONFIG ?= "x11 opengl gles2 webcrypto gst_gl video"
PACKAGECONFIG[webcrypto] = "-DENABLE_WEB_CRYPTO=ON,-DENABLE_WEB_CRYPTO=OFF,libgcrypt libtasn1"
PACKAGECONFIG[gst_gl] = "-DUSE_GSTREAMER_GL=ON,-DUSE_GSTREAMER_GL=OFF,gstreamer1.0-plugins-bad"

