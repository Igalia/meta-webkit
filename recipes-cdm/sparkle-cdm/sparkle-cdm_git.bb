SUMMARY = "Sparkle-CDM"
HOMEPAGE = "https://github.com/Sparkle-CDM/sparkle-cdm"
BUGTRACKER = "https://github.com/Sparkle-CDM/sparkle-cdm/issues"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=5d34cbc44b66f4a9ddc9afa73e13eda5"

DEPENDS = "glib-2.0 gstreamer1.0"

inherit meson pkgconfig

PV = "2021.0"

SRC_URI = "git://github.com/Sparkle-CDM/sparkle-cdm.git;protocol=https;branch=main"
SRCREV = "2c285c371f23a00820d1f31cd4e97b94435aace9"

S = "${WORKDIR}/git"

PACKAGECONFIG ?= ""
PACKAGECONFIG[sample-player] = "-Dsample-player=enabled,-Dsample-player=disabled,libsoup-2.4"

PROVIDES += "virtual/open-cdm"
RPROVIDES:${PN} += "virtual/open-cdm"

PACKAGES =+ "${PN}-sample-player"

FILES:${PN} += "${libdir}/libocdm.so \
                ${libdir}/gstreamer-1.0/libgstsprkl.so \
"
FILES:${PN}-sample-player += "${bindir}/sample-player"
FILES_SOLIBSDEV = ""

