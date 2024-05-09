require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0002-Activate-HAVE_MISSING_STD_FILESYSTEM_PATH_CONSTRUCTO.patch \
          "

SRC_URI[tarball.sha256sum] = "2c9fbf4fcf8884d34102283e2b008ce0b0bc2cf07de78f564a8b34347e7bc19b"

SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=main"

# Since 2.44+. The ENABLE_ACCESSIBILITY build option has been removed.
# A new USE_ATK option may be used to disable accessibility.
PACKAGECONFIG[accessibility] = "-DUSE_ATK=ON,-DUSE_ATK=OFF,atk at-spi2-atk"

# libbacktrace. Since 2.44+
PACKAGECONFIG[libbacktrace] = "-DUSE_LIBBACKTRACE=ON,-DUSE_LIBBACKTRACE=OFF,libbacktrace"

# The WPE 2.44.X branch was forked from the main branch in this commit
SRCREV:class-devupstream = "39f0dc749a8d05eb34bbbcf497b5e44f4ff9e68d"

PACKAGECONFIG:append = " libbacktrace"

DEPENDS += " libinput libtasn1"
