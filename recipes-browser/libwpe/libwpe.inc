SUMMARY = "General-purpose library specifically developed for the WPEWebKit."
DESCRIPTION = "libwpe is a general-purpose C library that provides \
               platform-agnostic interfaces for integrating WPE WebKit with \
               various backend implementations"
HOMEPAGE = "https://github.com/WebPlatformForEmbedded/libwpe"
BUGTRACKER = "https://github.com/WebPlatformForEmbedded/libwpe/issues"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=371a616eb4903c6cb79e9893a5f615cc"

DEPENDS:append = " virtual/egl"

PROVIDES += "virtual/libwpe"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"

# nooelint: oelint.vars.specific - Workaround build issue with RPi userland EGL libraries.
CFLAGS:append:rpi = " ${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '', '-D_GNU_SOURCE', d)}"

inherit features_check pkgconfig meson

REQUIRED_DISTRO_FEATURES = "opengl"

