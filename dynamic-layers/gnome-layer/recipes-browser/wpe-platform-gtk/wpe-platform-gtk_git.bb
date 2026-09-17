SUMMARY = "A GTK implementation of the WPE platform API"
DESCRIPTION = "WPEPlatformGTK implements the WPEPlatform interfaces on top of GTK4. \
               It installs a WPEPlatform module so that WPE WebKit can render into \
               a GTK widget, plus a library for applications embedding that widget."
HOMEPAGE = "https://github.com/Igalia/wpe-platform-gtk"
BUGTRACKER = "https://github.com/Igalia/wpe-platform-gtk/issues"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=56a5662fd4e62162de6c69e53a665974"

REQUIRED_DISTRO_FEATURES = "opengl"
# gtk4 needs a windowing backend, so skip cleanly on headless distros.
ANY_OF_DISTRO_FEATURES = "wayland x11"

# wpewebkit must be built with the wpe-platform PACKAGECONFIG, which provides
# the wpe-platform-2.0 pkg-config module this builds against.
DEPENDS = "glib-2.0 gtk4 libepoxy wpewebkit"

PV = "0.0.1"

SRC_URI = "git://github.com/Igalia/wpe-platform-gtk.git;protocol=https;branch=main;destsuffix=${BP}"
SRCREV = "85cab6c968c742d98087c5f9393e51cc301828f4"

inherit meson pkgconfig features_check

# Both the library and the WPEPlatform module are unversioned, so keep them in
# the runtime package instead of letting the .so land in ${PN}-dev.
SOLIBS = ".so"
FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/wpe-platform-*/modules/libgiowpeplatform-gtk.so"

# nooelint: oelint.vars.insaneskip - the shipped libraries are intentionally unversioned
INSANE_SKIP:${PN} = "dev-so"
