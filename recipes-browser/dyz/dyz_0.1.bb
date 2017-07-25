LICENSE = "CLOSED"

DEPENDS = "webkitwpe glib-2.0 luajit-native luajit"
RDEPENDS_${PN} = "glib-2.0-dev webkitwpe-dev"

SRCREV = "6a3574e8e924e2d4c85bbee1dd7d821a87b72d2b"
SRC_URI = "git://github.com/clopez/dyz.git;protocol=https;branch=crossbuild"

inherit autotools

S = "${WORKDIR}/git"
B = "${S}"

INSANE_SKIP_${PN} = "dev-deps"