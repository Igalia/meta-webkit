SUMMARY = "WPE's backend based on a freedesktop.org stack."
DESCRIPTION = "WPEBackend-fdo is a backend for the WPE WebKit port that leverages a standard freedesktop.org stack. It provides the necessary components to run WPE applications on systems using Wayland for display and libinput for input handling, ensuring broad compatibility with modern Linux desktop and embedded environments."
HOMEPAGE = "https://github.com/Igalia/WPEBackend-fdo"
BUGTRACKER = "https://github.com/Igalia/WPEBackend-fdo/issues"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=1f62cef2e3645e3e74eb05fd389d7a66"

inherit meson features_check pkgconfig

DEPENDS += "glib-2.0 libepoxy libwpe libxkbcommon wayland"
DEPENDS:append:class-target = " wayland-native"

PROVIDES += "virtual/wpebackend"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"

FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/libWPEBackend-fdo-*.so"

# nooelint: oelint.vars.insaneskip - ignored for convenience. We need to recheck if problem persist
INSANE_SKIP:${PN} = "dev-so"

RPROVIDES:${PN} += "virtual-wpebackend"

REQUIRED_DISTRO_FEATURES = "opengl"

