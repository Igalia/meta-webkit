require webkitgtk.inc

DEPENDS += " libgcrypt"

SRC_URI = "\
   https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
"

SRC_URI[md5sum] = "c4686971eac2760bab685e21ac8849be"
SRC_URI[sha256sum] = "87b6bb9a6065b949ecbe6191313c43e57ad28efdf1f2b5e763405093520632b8"

PACKAGECONFIG ?= "x11 opengl gles2 webcrypto gst_gl"
PACKAGECONFIG[webcrypto] = "-DENABLE_WEB_CRYPTO=ON,-DENABLE_WEB_CRYPTO=OFF,libgcrypt libtasn1"
PACKAGECONFIG[gst_gl] = "-DUSE_GSTREAMER_GL=ON,-DUSE_GSTREAMER_GL=OFF,gstreamer1.0-plugins-bad"

