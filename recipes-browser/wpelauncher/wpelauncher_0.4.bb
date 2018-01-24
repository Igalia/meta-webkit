LICENSE = "CLOSED"

DEPENDS += "wpewebkit glib-2.0"

SRCREV = "25aac1d84313262dc31298376796ac54a4bc536b"

SRC_URI = " \
    git://github.com/WebPlatformForEmbedded/WPEWebKitLauncher.git;protocol=http;branch=master \
    file://0001-Implement-a-watchdog-like-feature-to-monitor-the-WPE.patch \
    file://0002-Make-the-WPE-freeze-monitor-and-its-thresolds-config.patch \
    "

S = "${WORKDIR}/git"

inherit cmake

FILES_SOLIBSDEV = ""
INSANE_SKIP ="dev-so"
FILES_${PN} += "${libdir}/*.so"
