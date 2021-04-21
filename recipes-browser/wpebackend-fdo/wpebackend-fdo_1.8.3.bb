require wpebackend-fdo.inc
require conf/include/devupstream.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "3d0b4282a1bd9e0664d7a20abe14e982f3285296ac62de56cae2a404b9d28b9e"

# Those dependencies shall be promoted to the next wpebackend-fdo 1.8.X releases
# converving the older dependencies for packages previous to this version.
DEPENDS_class-devupstream = "glib-2.0 libxkbcommon wayland libepoxy libwpe"

SRC_URI_class-devupstream = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master"
SRCREV_class-devupstream = "6796611f4a0c5b11ebc58466d73880ef2781e4ef"
