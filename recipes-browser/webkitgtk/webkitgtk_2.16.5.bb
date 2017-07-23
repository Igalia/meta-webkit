require webkitgtk.inc

DEPENDS += " libgcrypt gettext-native glib-2.0-native"

SRC_URI = "\
   https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
   file://eglplatform.h-does-not-support-Wayland.patch \
"

SRC_URI[md5sum] = "fce72dc89cd310a663d9eb97133861fe"
SRC_URI[sha256sum] = "8e0396f3428e757898c5856e642eed4fcd5a20ae03d96d3eaa03b76634be7dd4"
