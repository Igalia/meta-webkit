LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=bf1229cd7425b302d60cdb641b0ce5fb"
DEPENDS = "wpewebkit libsoup-2.4 glib-2.0 ninja-native"

SRCREV = "b6d621af5d444fa3a2b78cc6da41463c33a78cc2"
SRC_URI = "git://github.com/aperezdc/dinghy.git;protocol=https;branch=master"

inherit cmake

S = "${WORKDIR}/git"
B = "${S}"

EXTRA_OECMAKE += " \
    -DDY_USE_MODE_MONITOR=ON -DDY_USE_DRM_MODE_MONITOR=ON \
    -G Ninja \
"
