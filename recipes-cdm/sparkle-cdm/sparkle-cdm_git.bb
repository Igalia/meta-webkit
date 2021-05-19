SUMMARY = "Sparkle-CDM"
HOMEPAGE = "https://github.com/Sparkle-CDM/sparkle-cdm"
BUGTRACKER = "https://github.com/Sparkle-CDM/sparkle-cdm/issues"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=5d34cbc44b66f4a9ddc9afa73e13eda5"

DEPENDS = "glib-2.0 gstreamer1.0"

inherit meson pkgconfig

PV = "2021.0"

SRC_URI = "git://github.com/Sparkle-CDM/sparkle-cdm.git;protocol=https;branch=main"
SRCREV = "31e063770f43acc343df1bfd920a5baa76722af0"

S = "${WORKDIR}/git"

PROVIDES += "virtual/open-cdm"
RPROVIDES_${PN} += "virtual/open-cdm"

FILES_${PN} += "${libdir}/libocdm.so"
FILES_SOLIBSDEV = ""

