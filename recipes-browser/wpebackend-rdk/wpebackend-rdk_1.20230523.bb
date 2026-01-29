require wpebackend-rdk.inc

DEPENDS += "libinput"

PROVIDES:append:class-devupstream = " virtual/wpebackend"

PV = "1.20221201"

SRC_URI = "git://github.com/WebPlatformForEmbedded/WPEBackend-rdk.git;protocol=https;branch=master;destsuffix=${BP}"
SRC_URI:class-devupstream = "git://github.com/WebPlatformForEmbedded/WPEBackend-rdk.git;protocol=https;branch=master;destsuffix=${BP}"

SRCREV = "108e4ab0da043421202e3ef64e0a38d1db8b82ee"
SRCREV:class-devupstream = "108e4ab0da043421202e3ef64e0a38d1db8b82ee"

RPROVIDES:${PN}:append:class-devupstream = " virtual-wpebackend"

BBCLASSEXTEND += "devupstream:target"
