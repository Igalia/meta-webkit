LICENSE = "CLOSED"

DEPENDS = "wpewebkit glib-2.0 luajit-native luajit"
RDEPENDS_${PN} = "glib-2.0-dev wpewebkit-dev"

SRCREV = "ec7a8b93e2c6afb04a7f7feb76d28bfddffaaea0"
SRC_URI = "git://github.com/Igalia/dyz.git;protocol=https;branch=master"

inherit autotools

S = "${WORKDIR}/git"
B = "${S}"

LDFLAGS="-ldl -lm"

INSANE_SKIP_${PN} = "dev-deps"
