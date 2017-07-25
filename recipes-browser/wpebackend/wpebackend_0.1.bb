LICENSE = "CLOSED"
DEPENDS += "virtual/egl"

SRCREV = "a1e18511ae8cd48cb1abccc62811a31194f3124c"

#SRC_URI = "git://github.com/WebPlatformForEmbedded/WPEBackend.git;protocol=https;branch=master"
SRC_URI = "git://github.com/clopez/WPEBackend.git;protocol=https;branch=find-egl"

S = "${WORKDIR}/git"

FULL_OPTIMIZATION_remove = "-g"

inherit cmake

CXXFLAGS += " \
-D_GLIBCXX_USE_CXX11_ABI=0 \
-D_GNU_SOURCE \
"

CFLAGS += " \
-D_GNU_SOURCE \
"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/libWPEBackend.so ${libdir}/pkgconfig/wpe.pc"
INSANE_SKIP_${PN} ="dev-so"
