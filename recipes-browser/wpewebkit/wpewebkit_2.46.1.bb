require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball"

SRC_URI[tarball.sha256sum] = "1e0aaf870f36001c42b1ce5a2027b4101bed878746e437cc6d6fed0693afe9ad"

SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=main"

SRCREV:class-devupstream = "8db1e051cf4a6d7877dd51b81b478e8367d3f052"

# Experimental new WPE platform API
PACKAGECONFIG[experimental-wpe-platform] = "-DENABLE_WPE_PLATFORM=ON,-DENABLE_WPE_PLATFORM=OFF,libinput"

EXTRA_OECMAKE += "-DUSE_SYSTEM_SYSPROF_CAPTURE=OFF"
