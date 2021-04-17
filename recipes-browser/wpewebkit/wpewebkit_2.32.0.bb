require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz \
    file://musl.patch \
    file://0001-ICU-69-deprecates-ubrk_safeClone-in-favor-of-ubrk_cl.patch \
    file://0001-Move-cloneUBreakIterator-declaration-to-IntlWorkarou.patch \
"

SRC_URI[sha256sum] = "6cfb18af9a180eeffffcaf34fea68d867ee59f633d811ced92bbead2d184b6ea"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.4) wpebackend-fdo (< 1.6)"

SRC_URI_class-devupstream = "git://git.webkit.org/WebKit.git;branch=master"
SRCREV_class-devupstream = "b410adfdbd2835d90a4bf86282ba742448848c94"

