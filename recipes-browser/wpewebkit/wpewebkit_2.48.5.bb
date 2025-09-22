require wpewebkit.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-Enforce-surface-size-match-when-maximized-to-avoid-W.patch \
           file://0002-REGRESSION-2.48.5-WPE-GTK-Does-not-compile-on-ARMv7.patch \
          "

SRC_URI[tarball.sha256sum] = "01f36010705adb14404c56baf033147f7927cc7c6badec81bb141266fcdd8d0b"

# Experimental new WPE platform API
PACKAGECONFIG[experimental-wpe-platform] = "-DENABLE_WPE_PLATFORM=ON,-DENABLE_WPE_PLATFORM=OFF,libinput wayland-native"

PACKAGECONFIG[soup2] = "-DUSE_SOUP2=ON,-DUSE_SOUP2=OFF,libsoup-2.4"
