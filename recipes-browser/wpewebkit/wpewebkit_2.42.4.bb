require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# WebKit 2.42 requires GCC>=10 (not provided in dunfell) or Clang>=10
# (provided by meta-clang in dunfell)
TOOLCHAIN = "${@bb.utils.contains_any("LAYERSERIES_CORENAMES", 'dunfell', 'clang', 'gcc', d)}"
LIBCPLUSPLUS = "${@bb.utils.contains_any("LAYERSERIES_CORENAMES", 'dunfell', '--stdlib=libc++', '', d)}"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-FELightningNEON.cpp-fails-to-build-NEON-fast-path-se_2.42.patch \
           file://0002-Fix-AudioSourceProviderGStreamer-build-with-ENABLE-M.patch \
           file://0003-Activate-HAVE_MISSING_STD_FILESYSTEM_PATH_CONSTRUCTO.patch \
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
