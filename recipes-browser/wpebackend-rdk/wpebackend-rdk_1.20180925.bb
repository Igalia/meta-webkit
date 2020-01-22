require wpebackend-rdk.inc

DEPENDS = "libwpe glib-2.0 libinput"

PV = "1.20180925"
SRCREV = "8ea61fbdee554a7cb2d1c1cbc53ce0868aaca304"

SRC_URI = "git://github.com/WebPlatformForEmbedded/WPEBackend-rdk.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

BBCLASSEXTEND += "devupstream:target"

PROVIDES_append_class-devupstream = " virtual/wpebackend"

SRC_URI_class-devupstream = "git://github.com/WebPlatformForEmbedded/WPEBackend-rdk.git;protocol=https;branch=master"
SRCREV_class-devupstream = "e0b491a9e30a05a094069a5d5037884703870e4a"

RPROVIDES_${PN}_append_class-devupstream += "virtual/wpebackend"
