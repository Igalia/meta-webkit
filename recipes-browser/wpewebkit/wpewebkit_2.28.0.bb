require wpewebkit.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"

SRC_URI[sha256sum] = "a85cd3cb46206a4929a9562d53379a7e7e2ec1a3224b34e2dcf5da30bb906722"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.2) wpebackend-fdo (< 1.2)"

BBCLASSEXTEND += "devupstream:target"

SRC_URI_class-devupstream = "git://git.webkit.org/WebKit.git;branch=master"
SRCREV_class-devupstream = "0f624128619b2b26ef87fb981eea4dbbd8dc63b5"
