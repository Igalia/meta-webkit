require wpebackend-rdk.inc

SRCREV = "196f75360b8643b119d8d96208d914998e5d4fc9"

PV = "1.20210402"

# devupstream
BBCLASSEXTEND += "devupstream:target"
PROVIDES_append_class-devupstream = " virtual/wpebackend"
SRC_URI_class-devupstream = "git://github.com/WebPlatformForEmbedded/WPEBackend-rdk.git;protocol=https;branch=master"
SRCREV_class-devupstream = "196f75360b8643b119d8d96208d914998e5d4fc9"
RPROVIDES_${PN}_append_class-devupstream += "virtual/wpebackend"
