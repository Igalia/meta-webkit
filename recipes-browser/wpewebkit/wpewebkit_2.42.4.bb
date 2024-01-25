require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-FELightningNEON.cpp-fails-to-build-NEON-fast-path-se_2.42.patch \
           file://0002-Fix-AudioSourceProviderGStreamer-build-with-ENABLE-M.patch \
          "

SRC_URI[tarball.sha256sum] = "8836040a3687581970b47a232b713e7023c080d5613427f52db619c29fb253a4"

DEPENDS += " libwpe virtual/wpebackend"

SRC_URI:class-devupstream = "\
    git://github.com/WebKit/WebKit.git;protocol=https;branch=main \
"

# WPE 2.42.X branch was forked from the main branch in this commit
SRCREV:class-devupstream = "33c49ff64449389431294ba0ace6f7d0ad6306b7"

# jpegxl: Added in 2.42+
PACKAGECONFIG[jpegxl] = "-DUSE_JPEGXL=ON,-DUSE_JPEGXL=OFF,libjxl"
PACKAGECONFIG:append = " ${@bb.utils.contains_any('LAYERSERIES_CORENAMES', 'dunfell gatesgarth hardknott honister', '', 'jpegxl', d)}"
