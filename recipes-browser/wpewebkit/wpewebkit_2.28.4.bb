require wpewebkit.inc
require conf/include/devupstream.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"

SRC_URI[sha256sum] = "785d83b99cd45cedb7c4f1f697db773a5a81eb0a42aeeafa3c623053f6fde87a"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.2) wpebackend-fdo (< 1.2)"

SRC_URI_class-devupstream = "git://git.webkit.org/WebKit.git;branch=master"
SRCREV_class-devupstream = "4d2d7cbbdbfef826e5f35107e71d908a87a86e92"

