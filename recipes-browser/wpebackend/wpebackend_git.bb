SUMMARY = "General-purpose library specifically developed for the WPE-flavored port of WebKit."
HOMEPAGE = "https://github.com/WebPlatformForEmbedded/WPEBackend"
BUGTRACKER = "https://github.com/WebPlatformForEmbedded/WPEBackend/issues"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=6ae4db0d4b812334e1539cd5aa6e2f46"
DEPENDS += "virtual/egl"

PV = "1.20170824"
SRCREV = "aaab302388b1e75c8c085b184b1c0800557e3a6b"


SRCREV = "0272534fcc3bf1aff56539e20703b8d53a0328cc"

SRC_URI = " \
            git://github.com/WebPlatformForEmbedded/WPEBackend.git;protocol=https;branch=master \
            file://PR4.patch \
          "

S = "${WORKDIR}/git"


inherit cmake


FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/libWPEBackend.so ${libdir}/pkgconfig/wpe.pc"
INSANE_SKIP_${PN} ="dev-so"
