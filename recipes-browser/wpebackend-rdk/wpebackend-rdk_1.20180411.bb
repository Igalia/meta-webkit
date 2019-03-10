require wpebackend-rdk.inc

DEPENDS = "wpebackend glib-2.0 libinput"

SRCREV = "456f7c1470d0dba61399bd593f34a0b0316158cf"

SRC_URI = " git://github.com/WebPlatformForEmbedded/WPEBackend-rdk.git;protocol=https;branch=master \
            file://0001-WPEBackend-libraries-are-versioned-now.patch \
            file://0001-Fix-include-of-headers-after-WPEBackend-commit-2bf3c.patch \
          "

S = "${WORKDIR}/git"
