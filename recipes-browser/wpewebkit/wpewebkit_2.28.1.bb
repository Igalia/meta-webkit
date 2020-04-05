require wpewebkit.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz \
           file://0001-Fix-build-with-musl.patch \
           file://reduce-jsc-stack-heap.patch \
          "

SRC_URI[sha256sum] = "3763a536d55529bbf66fa3772e9c1b543ddf882fabd0ca337076555b176ee8c5"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.2) wpebackend-fdo (< 1.2)"

BBCLASSEXTEND += "devupstream:target"

SRC_URI_class-devupstream = "git://git.webkit.org/WebKit.git;branch=master"
SRCREV_class-devupstream = "0f624128619b2b26ef87fb981eea4dbbd8dc63b5"
