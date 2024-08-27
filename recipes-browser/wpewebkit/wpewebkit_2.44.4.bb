require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0002-Activate-HAVE_MISSING_STD_FILESYSTEM_PATH_CONSTRUCTO.patch \
          "

SRC_URI[tarball.sha256sum] = "cd6042c63a6f883cc1586e5cea94e846aaaee6a864c14988e8af4ef4f362ba3b"

SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=main"

# Since 2.44+. The ENABLE_ACCESSIBILITY build option has been removed.
# A new USE_ATK option may be used to disable accessibility.
PACKAGECONFIG[accessibility] = "-DUSE_ATK=ON,-DUSE_ATK=OFF,atk at-spi2-atk"

# libbacktrace. Since 2.44+
PACKAGECONFIG[libbacktrace] = "-DUSE_LIBBACKTRACE=ON,-DUSE_LIBBACKTRACE=OFF,libbacktrace"

SRCREV:class-devupstream = "fd73f137dcc66fd5c7146c3d9578346e77ae6d0a"

PACKAGECONFIG:append = " libbacktrace"

DEPENDS += " libinput libtasn1"
