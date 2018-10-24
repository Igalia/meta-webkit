require webkitgtk.inc

DEPENDS += " libgcrypt"

SRC_URI = "\
   https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
"

SRC_URI[md5sum] = "9f08d09cfc21c761a431a545549f301a"
SRC_URI[sha256sum] = "fab5be2883802352ae0e735dd1eff4bc18abaff7ac78689cec72eb2f611943b8"

PACKAGECONFIG ?= " ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)} \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'opengl gles2 gst_gl webgl', '', d)} \
                   video \
                   webcrypto \
                   woff2 "
PACKAGECONFIG[webcrypto] = "-DENABLE_WEB_CRYPTO=ON,-DENABLE_WEB_CRYPTO=OFF,libgcrypt libtasn1"
PACKAGECONFIG[gst_gl] = "-DUSE_GSTREAMER_GL=ON,-DUSE_GSTREAMER_GL=OFF,gstreamer1.0-plugins-base"
PACKAGECONFIG[woff2] = "-DUSE_WOFF2=ON,-DUSE_WOFF2=OFF,woff2"
