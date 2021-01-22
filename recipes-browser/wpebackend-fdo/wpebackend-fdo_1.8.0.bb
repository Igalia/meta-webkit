require wpebackend-fdo.inc

inherit cmake

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "9652a99c75fe1c6eab0585b6395f4e104b2427e4d1f42969f1f77df29920d253"

# These dependencies are needed since wpebackend-fdo>=1.8.X
# TODO: Promote it to the wpebackend-fdo.inc once wpebackend-fdo=1.6.1 is
# removed from this repo.
DEPENDS = "glib-2.0 libxkbcommon wayland libepoxy libwpe"
