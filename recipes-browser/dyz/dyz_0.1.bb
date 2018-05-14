LICENSE = "CLOSED"

DEPENDS = "wpewebkit glib-2.0 luajit-native luajit"
RDEPENDS_${PN} = "glib-2.0-dev wpewebkit-dev"

SRCREV = "ec7a8b93e2c6afb04a7f7feb76d28bfddffaaea0"
SRC_URI = "git://github.com/Igalia/dyz.git;protocol=https;branch=master \
           file://0001-Fixed-luajit-native-path.patch \
"

inherit autotools

S = "${WORKDIR}/git"
B = "${S}"

LDFLAGS="-ldl -lm"

INSANE_SKIP_${PN} = "dev-deps"

do_compile_prepend() {
    export LUA_PATH="${RECIPE_SYSROOT_NATIVE}/usr/share/luajit-2.0.5/?.lua"
}
