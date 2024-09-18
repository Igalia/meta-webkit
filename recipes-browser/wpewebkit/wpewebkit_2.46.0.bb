require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-CMake-WPE-ENABLE_WPE_PLATFORM-cannot-be-toggled.patch \
          "

SRC_URI[tarball.sha256sum] = "301550fbd8703f3ba4c4a65fe596686960569f8a3b0f6668243179cbc77bbc50"

SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=main"

SRCREV:class-devupstream = "8db1e051cf4a6d7877dd51b81b478e8367d3f052"

