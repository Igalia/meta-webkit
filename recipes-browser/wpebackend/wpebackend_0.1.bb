LICENSE = "CLOSED"
DEPENDS += "virtual/egl"

SRCREV = "38e216ab1858cd3b571855cda3fd47266cd89f9c"

#SRC_URI = "git://github.com/WebPlatformForEmbedded/WPEBackend.git;protocol=https;branch=master"
SRC_URI = "git://github.com/clopez/WPEBackend.git;protocol=https;branch=find-egl"

S = "${WORKDIR}/git"


inherit cmake

CXXFLAGS += " \
-D_GNU_SOURCE \
"

CFLAGS += " \
-D_GNU_SOURCE \
"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/libWPEBackend.so ${libdir}/pkgconfig/wpe.pc"
INSANE_SKIP_${PN} ="dev-so"
