require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0002-Activate-HAVE_MISSING_STD_FILESYSTEM_PATH_CONSTRUCTO.patch \
           file://0003-LowLevelInterpreter.cpp-339-21-error-t6-was-not-decl.patch \
           file://0004-GLib-Script-rewrite-compile-commands-missing-from-re.patch \
           file://0005-WPE-GTK-Unreviewed-fix-build-for-Ubuntu-LTS-after-27.patch \
          "

SRC_URI[tarball.sha256sum] = "0741862b559da0cbbf8e0bccb057361f8a1c6a96178ba10aa0375030b01f05d4"

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
