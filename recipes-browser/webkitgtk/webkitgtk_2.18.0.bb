require webkitgtk.inc

DEPENDS += " libgcrypt gettext-native glib-2.0-native"

SRC_URI = "\
   https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
   file://GTK-Fails-to-build-because-Float32Array-has-not-been.patch \
   file://Add-a-switch-to-start-the-mini-browser-in-full-s.patch \
"

SRC_URI[md5sum] = "10d86dd5a5b68875654cc38af139f382"
SRC_URI[sha256sum] = "b583e46a3de36a3e80ba33b084ead60512a2046aca01ff61e50e519436e5038d"

PACKAGECONFIG ?= "x11 opengl gles2 webcrypto gst_gl"
PACKAGECONFIG[webcrypto] = "-DENABLE_WEB_CRYPTO=ON,-DENABLE_WEB_CRYPTO=OFF,libgcrypt libtasn1"
PACKAGECONFIG[gst_gl] = "-DUSE_GSTREAMER_GL=ON,-DUSE_GSTREAMER_GL=OFF,gstreamer1.0-plugins-bad"

