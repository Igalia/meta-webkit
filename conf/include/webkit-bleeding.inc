# Configure select recipes to use the latest upstream source.
# Add the following to local.conf to enable it:
#
#   require conf/include/webkit-bleeding.inc

PREFERRED_VERSION_cog = "0.16+httpsAUTOINC+%"
PREFERRED_VERSION_libwpe = "1.14+httpsAUTOINC+%"
PREFERRED_VERSION_wpebackend-fdo = "devupstream+gitAUTOINC+%"
PREFERRED_VERSION_wpebackend-rdk = "1.20200213+gitAUTOINC+%"
PREFERRED_VERSION_wpewebkit = "2.38+httpsAUTOINC+%"

SRCREV:class-devupstream:pn-cog = "${AUTOREV}"
SRCREV:class-devupstream:pn-libwpe = "${AUTOREV}"
SRCREV:class-devupstream:pn-wpebackend-fdo = "${AUTOREV}"
SRCREV:class-devupstream:pn-wpebackend-rdk = "${AUTOREV}"
SRCREV:class-devupstream:pn-wpewebkit = "${AUTOREV}"
