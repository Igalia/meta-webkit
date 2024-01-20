require wpebackend-rdk.inc

DEPENDS = "libwpe glib-2.0 libinput"

PV = "1.20221201"
SRCREV = "108e4ab0da043421202e3ef64e0a38d1db8b82ee"

SRC_URI = "git://github.com/WebPlatformForEmbedded/WPEBackend-rdk.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

BBCLASSEXTEND += "devupstream:target"

PROVIDES:append:class-devupstream = " virtual/wpebackend"

SRC_URI:class-devupstream = "git://github.com/WebPlatformForEmbedded/WPEBackend-rdk.git;protocol=https;branch=master"
SRCREV:class-devupstream = "108e4ab0da043421202e3ef64e0a38d1db8b82ee"

RPROVIDES:${PN}:append:class-devupstream = "virtual-wpebackend"
