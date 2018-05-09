require webkitgtk.inc

DEPENDS += " libgcrypt"

SRC_URI = "\
   https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
"

SRC_URI[md5sum] = "3fdda40dc10eb2a00d5fba4219b83967"
SRC_URI[sha256sum] = "dffe93a241f03f1c73b369f4e323e4d8f12e39d33d5515948cbf454ca4b526e2"

PACKAGECONFIG ?= " ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)} \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'opengl gles2 gst_gl webgl', '', d)} \
                   webcrypto \
                   woff2 "
PACKAGECONFIG[webcrypto] = "-DENABLE_WEB_CRYPTO=ON,-DENABLE_WEB_CRYPTO=OFF,libgcrypt libtasn1"
PACKAGECONFIG[gst_gl] = "-DUSE_GSTREAMER_GL=ON,-DUSE_GSTREAMER_GL=OFF,gstreamer1.0-plugins-bad"
PACKAGECONFIG[woff2] = "-DUSE_WOFF2=ON,-DUSE_WOFF2=OFF,woff2"
