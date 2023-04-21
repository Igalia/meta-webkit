require wpewebkit.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-FELightningNEON.cpp-fails-to-build-NEON-fast-path-se.patch \
          "

SRC_URI[tarball.sha256sum] = "dcb6591456393c5366ad9abc62a808137d4fea039cbc7ef4c8d64ead506d035b"

DEPENDS += " libwpe"
RCONFLICTS:${PN} = "libwpe (< 1.12)"

# documentation: Needed from 2.38
PACKAGECONFIG[documentation] = "-DENABLE_DOCUMENTATION=ON,-DENABLE_DOCUMENTATION=OFF, gi-docgen-native gi-docgen"

# introspection: Needed from 2.38
PACKAGECONFIG[introspection] = "-DENABLE_INTROSPECTION=ON,-DENABLE_INTROSPECTION=OFF, gobject-introspection-native"

# TODO: documentation and introspection are disabled by default because the are
# causing cross-compiling build errors
# PACKAGECONFIG:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'api-documentation', 'documentation', '' ,d)} introspection"

# Layer-Based SVG Engine
PACKAGECONFIG[lbse] = "-DENABLE_LAYER_BASED_SVG_ENGINE=ON,-DENABLE_LAYER_BASED_SVG_ENGINE=OFF, "

# Needed for <= 2.38.5
# Upstream-Status: Merged [https://github.com/WebKit/WebKit/pull/11288]
EXTRA_OECMAKE:append = " -DENABLE_TOUCH_SLIDER=ON"
