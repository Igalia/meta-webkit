require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-FELightningNEON.cpp-fails-to-build-NEON-fast-path-se.patch \
          "

SRC_URI[tarball.sha256sum] = "5ce5ac6d5cb6c13469f52d2ece34b302524ff59caf05ecf0f7c62e12c48df422"

DEPENDS += " libwpe"
RCONFLICTS:${PN} = "libwpe (< 1.12)"

SRC_URI:class-devupstream = "\
    git://github.com/WebKit/WebKit.git;protocol=https;branch=main \
"

# WPE 2.38.X branch was forked from the main branch in this commit
SRCREV:class-devupstream = "ab63faf432abcb7cfc469fbb1a0d2a89c94cfa20"

# documentation: Needed from 2.38
PACKAGECONFIG[documentation] = "-DENABLE_DOCUMENTATION=ON,-DENABLE_DOCUMENTATION=OFF, gi-docgen-native gi-docgen"

# introspection: Needed from 2.38
PACKAGECONFIG[introspection] = "-DENABLE_INTROSPECTION=ON,-DENABLE_INTROSPECTION=OFF, gobject-introspection-native"

# webgl2: Activated by default from >2.38
PACKAGECONFIG:append:class-devupstream = " webgl2"

# TODO: documentation and introspection are disabled by default because the are
# causing cross-compiling build errors
# PACKAGECONFIG:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'api-documentation', 'documentation', '' ,d)} introspection"

# Layer-Based SVG Engine
PACKAGECONFIG[lbse] = "-DENABLE_LAYER_BASED_SVG_ENGINE=ON,-DENABLE_LAYER_BASED_SVG_ENGINE=OFF, "

# unifdef-native: Needed since >2.38.
DEPENDS:append:class-devupstream = " unifdef-native"
