require wpebackend-fdo.inc
require conf/include/devupstream.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "9652a99c75fe1c6eab0585b6395f4e104b2427e4d1f42969f1f77df29920d253"

# Those dependencies shall be promoted to the next wpebackend-fdo 1.8.X releases
# converving the older dependencies for packages previous to this version.
DEPENDS_class-devupstream = "glib-2.0 libxkbcommon wayland libepoxy libwpe"

SRC_URI_class-devupstream = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master"
SRCREV_class-devupstream = "6796611f4a0c5b11ebc58466d73880ef2781e4ef"
