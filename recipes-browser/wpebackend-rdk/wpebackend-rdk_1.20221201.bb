require wpebackend-rdk.inc

DEPENDS = "libwpe glib-2.0 libinput"

PV = "1.20221201"
SRCREV = "f0475a271211efc501fc810304b5dc69a5e12bbb"

SRC_URI = "git://github.com/WebPlatformForEmbedded/WPEBackend-rdk.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

BBCLASSEXTEND += "devupstream:target"

PROVIDES:append:class-devupstream = " virtual/wpebackend"

SRC_URI:class-devupstream = "git://github.com/WebPlatformForEmbedded/WPEBackend-rdk.git;protocol=https;branch=master"
SRCREV:class-devupstream = "f0475a271211efc501fc810304b5dc69a5e12bbb"

RPROVIDES:${PN}:append:class-devupstream = "virtual/wpebackend"
