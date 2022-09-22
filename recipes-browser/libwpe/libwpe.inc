SUMMARY = "General-purpose library specifically developed for the WPE-flavored port of WebKit."
HOMEPAGE = "https://github.com/WebPlatformForEmbedded/libwpe"
BUGTRACKER = "https://github.com/WebPlatformForEmbedded/libwpe/issues"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=371a616eb4903c6cb79e9893a5f615cc"
DEPENDS = "virtual/egl"

PROVIDES += "virtual/libwpe"
RPROVIDES:${PN} += "virtual/libwpe"

# Workaround build issue with RPi userland EGL libraries.
CFLAGS:append:rpi = " ${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '', '-D_GNU_SOURCE', d)}"

inherit features_check pkgconfig ${@bb.utils.contains_any("LAYERSERIES_CORENAMES", 'dunfell', 'cmake', 'meson', d)}

REQUIRED_DISTRO_FEATURES = "opengl"

