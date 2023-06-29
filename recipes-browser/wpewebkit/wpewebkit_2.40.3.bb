require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-FELightningNEON.cpp-fails-to-build-NEON-fast-path-se.patch \
          "

SRC_URI[tarball.sha256sum] = "05b6a9cb1d7d03485e0dc41b2a8e6f99a36aea23d32ba3ecb38d0d6860747ada"

DEPENDS += " libwpe"
RCONFLICTS:${PN} = "libwpe (< 1.12)"

SRC_URI:class-devupstream = "\
    git://github.com/WebKit/WebKit.git;protocol=https;branch=main \
"

# WPE 2.40.X branch was forked from the main branch in this commit
SRCREV:class-devupstream = "5b60400f474f318e45cd713638e365366b98dd87"

# documentation: Needed from 2.38
PACKAGECONFIG[documentation] = "-DENABLE_DOCUMENTATION=ON,-DENABLE_DOCUMENTATION=OFF, gi-docgen-native gi-docgen"

# introspection: Needed from 2.38
PACKAGECONFIG[introspection] = "-DENABLE_INTROSPECTION=ON,-DENABLE_INTROSPECTION=OFF, gobject-introspection-native"

# webgl2: Activated by default from >2.38
PACKAGECONFIG:append = " webgl2"

# TODO: documentation and introspection are disabled by default because the are
# causing cross-compiling build errors
# PACKAGECONFIG:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'api-documentation', 'documentation', '' ,d)} introspection"

# Layer-Based SVG Engine
PACKAGECONFIG[lbse] = "-DENABLE_LAYER_BASED_SVG_ENGINE=ON,-DENABLE_LAYER_BASED_SVG_ENGINE=OFF, "

# Build option for WPE API 1.1
PACKAGECONFIG[wpe-1-1-api] = "-DENABLE_WPE_1_1_API:BOOL=ON,-DENABLE_WPE_1_1_API:BOOL=OFF,"
# temporarily enable WPE API 1.1 for cog 0.16
PACKAGECONFIG:append = " wpe-1-1-api"

# unifdef-native: Needed since >2.38.
DEPENDS:append = " unifdef-native"

# Since 2.40.X
PACKAGECONFIG[gbm] = "-DUSE_GBM=ON,-DUSE_GBM=OFF,libdrm"
PACKAGECONFIG:append = " gbm"
