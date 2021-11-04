# Configure select recipes to use the latest upstream source.
# Add the following to local.conf to enable it:
#
#   require conf/include/webkit-bleeding.inc

PREFERRED_VERSION_cog = "0.10+gitAUTOINC+%"
PREFERRED_VERSION_libwpe = "1.12+gitAUTOINC+%"
PREFERRED_VERSION_wpebackend-fdo = "1.12+gitAUTOINC+%"
PREFERRED_VERSION_wpebackend-rdk = "1.20180925+gitAUTOINC+%"
PREFERRED_VERSION_wpewebkit = "2.34+gitAUTOINC+%"

SRCREV:class-devupstream:pn-cog = "${AUTOREV}"
SRCREV:class-devupstream:pn-libwpe = "${AUTOREV}"
SRCREV:class-devupstream:pn-wpebackend-fdo = "${AUTOREV}"
SRCREV:class-devupstream:pn-wpebackend-rdk = "${AUTOREV}"
SRCREV:class-devupstream:pn-wpewebkit = "${AUTOREV}"
