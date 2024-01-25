require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-FELightningNEON.cpp-fails-to-build-NEON-fast-path-se_2.42.patch \
           file://0002-Activate-HAVE_MISSING_STD_FILESYSTEM_PATH_CONSTRUCTO.patch \
           file://0003-LowLevelInterpreter.cpp-339-21-error-t6-was-not-decl.patch \
          "

SRC_URI[tarball.sha256sum] = "4dbab6c5e6dc0c65a3d7dffc1c2390be5f9abd423faf983fe3a55fe081df0532"

DEPENDS += " libwpe virtual/wpebackend"

SRC_URI:class-devupstream = "\
    git://github.com/WebKit/WebKit.git;protocol=https;branch=main \
"

# WPE 2.42.X branch was forked from the main branch in this commit
SRCREV:class-devupstream = "33c49ff64449389431294ba0ace6f7d0ad6306b7"

