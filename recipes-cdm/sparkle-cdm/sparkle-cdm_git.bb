SUMMARY = "Sparkle-CDM"
DESCRIPTION = "Sparkle-CDM is a shared library that implements the OpenCDM interface, enabling DRM-protected stream playback in WebKitGTK and WPEWebKit via EME and MSE. It features a plugin-based architecture, with built-in support for ClearKey decryption for testing. Additional DRM systems can be integrated by loading runtime plugins. The project also includes a standalone GStreamer decryptor for native applications."
HOMEPAGE = "https://github.com/Sparkle-CDM/sparkle-cdm"
BUGTRACKER = "https://github.com/Sparkle-CDM/sparkle-cdm/issues"
LICENSE = "MIT-open-group"
LIC_FILES_CHKSUM = "file://COPYING;md5=5d34cbc44b66f4a9ddc9afa73e13eda5"

DEPENDS = "glib-2.0 gstreamer1.0"

inherit meson pkgconfig

PROVIDES += "virtual/open-cdm"

PV = "2021.0"

SRC_URI = "git://github.com/Sparkle-CDM/sparkle-cdm.git;protocol=https;branch=main;destsuffix=${BP}"
SRCREV = "ce99d205e0423ab213869da5e934c0c1cd9983a8"

PACKAGECONFIG ?= ""
PACKAGECONFIG[sample-player] = "-Dsample-player=enabled,-Dsample-player=disabled,libsoup-2.4"
PACKAGECONFIG[clearkey-module] = "-Dclearkey-module=enabled,-Dclearkey-module=disabled,json-glib openssl"

PACKAGES =+ "${PN}-sample-player ${PN}-clearkey-module"

FILES:${PN} += "${libdir}/libocdm.so \
                ${libdir}/gstreamer-1.0/libgstsprkl.so \
"
FILES:${PN}-sample-player += "${bindir}/sample-player"
FILES:${PN}-clearkey-module += "${libdir}/sparkle-cdm/libsparkle-cdm-clearkey.so"
FILES_SOLIBSDEV = ""

