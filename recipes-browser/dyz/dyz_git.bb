SUMMARY = "dyz is a simple launcher for WPE port of WebKit. \
           dyz is written in Lua and depends on LuaJIT."
HOMEPAGE = "https://github.com/Igalia/dyz"
BUGTRACKER = "https://github.com/Igalia/dyz/issues"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=1f62cef2e3645e3e74eb05fd389d7a66"

# dyz depends on wpebackend-fdo
PREFERRED_PROVIDER_virtual/wpebackend = "wpebackend-fdo"
DEPENDS = "glib-2.0 libxkbcommon wpewebkit luajit luajit-native"
RDEPENDS_${PN} = "glib-2.0-dev libxkbcommon-dev wpewebkit-dev wpebackend-fdo ${PN}-dev"

# Please: keep PV to the date of the last update, so the version number
# is an always increasing number to avoid "version goes backwards" errors.
PV = "20180505"
SRCREV = "197fed66831ff2e5b16173662b48cae8476c1b72"
SRC_URI = "git://github.com/Igalia/dyz.git;protocol=https;branch=master"

inherit autotools

S = "${WORKDIR}/git"
B = "${S}"

INSANE_SKIP_${PN} = "dev-deps"
INSANE_SKIP_${PN}-dev = "dev-elf ldflags"


do_compile_prepend() {
	export LUAJIT="${RECIPE_SYSROOT_NATIVE}/usr/bin/luajit"
	export LUA_PATH="${RECIPE_SYSROOT_NATIVE}/usr/share/luajit-2.0.5/?.lua"
}
