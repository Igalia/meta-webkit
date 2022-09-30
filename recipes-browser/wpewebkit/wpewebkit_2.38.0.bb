require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-FELightningNEON.cpp-fails-to-build-NEON-fast-path-se.patch \
           file://0001-JSC-ARMv7-Fix-clang-compiler-errors-Constexpr-if-wit.patch \
          "

SRC_URI[tarball.sha256sum] = "e653e12eca63e6371c06d4cd9efcd5492db67f7d9ef324fd5d8668b1151e72b2"

DEPENDS += " libwpe"
RCONFLICTS:${PN} = "libwpe (< 1.12)"

SRC_URI:class-devupstream = "\
    git://github.com/WebKit/WebKit.git;protocol=https;branch=main \
"

# WPE 2.38.X branch was forked from the main branch in this commit
SRCREV:class-devupstream = "ab63faf432abcb7cfc469fbb1a0d2a89c94cfa20"

# documentation: Needed from 2.38
PACKAGECONFIG[documentation] = "-DENABLE_DOCUMENTATION=ON,-DENABLE_DOCUMENTATION=OFF, gi-docgen-native gi-docgen"

# instrospection: Needed from 2.38
PACKAGECONFIG[instrospection] = "-DENABLE_INTROSPECTION=ON,-DENABLE_INTROSPECTION=OFF, gobject-introspection-native"

# TODO: documentation and instrospection are disabled by default because the are
# causing cross-compiling build errors
# PACKAGECONFIG:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'api-documentation', 'documentation', '' ,d)} instrospection"

