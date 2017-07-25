LICENSE = "CLOSED"

DEPENDS += "wpewebkit glib-2.0"

SRCREV = "734991a2f851899adbdb1be7df7a27ccfe20c7d4"

SRC_URI = "git://github.com/WebPlatformForEmbedded/WPEWebKitLauncher.git;protocol=http;branch=master"

S = "${WORKDIR}/git"

FULL_OPTIMIZATION_remove = "-g"

CXXFLAGS += "-D_GLIBCXX_USE_CXX11_ABI=0"

inherit cmake

FILES_SOLIBSDEV = ""
INSANE_SKIP ="dev-so"
FILES_${PN} += "${libdir}/*.so"
