require wpebackend-fdo.inc

inherit cmake

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "8adb4475be949ae4092370de6a37d7b9e1d3704cf4674867312e87de2ff0d880"

# These dependencies are needed since wpebackend-fdo>=1.8.X
# TODO: Promote it to the wpebackend-fdo.inc once wpebackend-fdo=1.6.1 is
# removed from this repo.
DEPENDS = "glib-2.0 libxkbcommon wayland libepoxy libwpe"
