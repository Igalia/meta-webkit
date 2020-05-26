require wpebackend-fdo.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "740eee3327acfb462b8460519a219e30dc0a870326e88e2ddc4fe2c8de20b1c9"

BBCLASSEXTEND += "devupstream:target"

# Those dependencies shall be promoted to the next wpebackend-fdo 1.8.X releases
# converving the older dependencies for packages previous to this version.
DEPENDS_class-devupstream = "glib-2.0 libxkbcommon wayland libepoxy libwpe"

SRC_URI_class-devupstream = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master"
SRCREV_class-devupstream = "1123b61f49da162c1ad9fe08571917c5e2fd7a2a"
