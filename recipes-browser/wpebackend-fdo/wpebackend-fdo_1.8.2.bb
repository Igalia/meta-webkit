require wpebackend-fdo.inc

inherit cmake

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "98c291071128326a72918d670a46ef63268c43267928560ac3b84b6aebb2d78d"

# These dependencies are needed since wpebackend-fdo>=1.8.X
# TODO: Promote it to the wpebackend-fdo.inc once wpebackend-fdo=1.6.1 is
# removed from this repo.
DEPENDS = "glib-2.0 libxkbcommon wayland libepoxy libwpe"
