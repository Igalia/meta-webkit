require wpewebkit.inc
require conf/include/devupstream.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"

SRC_URI[sha256sum] = "d1a99383ac3344195d09b4a4256c15dc5269c8585b3d836f43a057e60bb6f460"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.2) wpebackend-fdo (< 1.2)"

SRC_URI_class-devupstream = "git://git.webkit.org/WebKit.git;branch=master"
SRCREV_class-devupstream = "8761d758f83fd7fda3d98a971cee02c38f765637"

