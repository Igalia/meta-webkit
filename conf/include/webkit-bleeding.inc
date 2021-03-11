# Configure select recipes to use the latest upstream source.
# Add the following to local.conf to enable it:
#
#   require conf/include/webkit-bleeding.inc

PREFERRED_VERSION_cog = "0.8.0+gitAUTOINC+%"
PREFERRED_VERSION_libwpe = "1.6.0+gitAUTOINC+%"
PREFERRED_VERSION_wpebackend-fdo = "1.8.1+gitAUTOINC+%"
PREFERRED_VERSION_wpebackend-rdk = "1.20180925+gitAUTOINC+%"
PREFERRED_VERSION_wpewebkit = "2.30.5+gitAUTOINC+%"

SRCREV_class-devupstream_pn-cog = "${AUTOREV}"
SRCREV_class-devupstream_pn-libwpe = "${AUTOREV}"
SRCREV_class-devupstream_pn-wpebackend-fdo = "${AUTOREV}"
SRCREV_class-devupstream_pn-wpebackend-rdk = "${AUTOREV}"
SRCREV_class-devupstream_pn-wpewebkit = "${AUTOREV}"
