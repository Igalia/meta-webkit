require wpewebkit.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"

SRC_URI[sha256sum] = "6929d28744702ead3574484ca02645c457a6fdcd6b43ccc9766d98dc3664e8dc"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.2) wpebackend-fdo (< 1.2)"

BBCLASSEXTEND += "devupstream:target"

SRC_URI_class-devupstream = "git://git.webkit.org/WebKit.git;branch=master"
SRCREV_class-devupstream = "0f624128619b2b26ef87fb981eea4dbbd8dc63b5"
