require wpebackend-fdo.inc

inherit cmake

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "3d0b4282a1bd9e0664d7a20abe14e982f3285296ac62de56cae2a404b9d28b9e"

# These dependencies are needed since wpebackend-fdo>=1.8.X
# TODO: Promote it to the wpebackend-fdo.inc once wpebackend-fdo=1.6.1 is
# removed from this repo.
DEPENDS = "glib-2.0 libxkbcommon wayland libepoxy libwpe"
