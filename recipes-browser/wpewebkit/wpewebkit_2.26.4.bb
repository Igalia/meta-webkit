require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz \
    file://Do-not-detect-the-stopped-animations.patch \
"
SRC_URI[md5sum] = "4cd2883ec9da38a0ffe413bb75239874"
SRC_URI[sha256sum] = "0c292182864b63b725491f1a69b55c03e0e75f6db0875389caff31fe9c0d3ae9"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.2) wpebackend-fdo (< 1.2)"

BBCLASSEXTEND += "devupstream:target"

SRC_URI_class-devupstream = "git://git.webkit.org/WebKit.git;branch=master"
SRCREV_class-devupstream = "17577d925d7f2e1a858b6d0eec964517100f27b0"

