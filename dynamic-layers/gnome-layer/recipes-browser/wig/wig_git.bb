SUMMARY = "A WPE WebKit browser using GTK"
DESCRIPTION = "Wig, short for WPE in GTK, is a minimal but functional web browser \
               built with GTK and Libadwaita. It renders web content with WPE WebKit \
               through WPEPlatformGTK and provides tab-based navigation."
HOMEPAGE = "https://github.com/Igalia/wig"
BUGTRACKER = "https://github.com/Igalia/wig/issues"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=56a5662fd4e62162de6c69e53a665974"

REQUIRED_DISTRO_FEATURES = "opengl"
# gtk4 needs a windowing backend, so skip cleanly on headless distros.
ANY_OF_DISTRO_FEATURES = "wayland x11"

DEPENDS = "glib-2.0 glib-2.0-native libadwaita libpsl sqlite3 wpe-platform-gtk wpewebkit"

PV = "0.0.1"

SRC_URI = "git://github.com/Igalia/wig.git;protocol=https;branch=main;destsuffix=${BP}"
SRCREV = "37d60b214420ed8559470088287cb56e8365fe3a"

inherit meson pkgconfig features_check gsettings mime-xdg

# The D-Bus session service is not covered by the default FILES. The GSettings
# schema is added by the gsettings class.
FILES:${PN} += "${datadir}/dbus-1/services"

RDEPENDS:${PN} += "wpe-platform-gtk"
