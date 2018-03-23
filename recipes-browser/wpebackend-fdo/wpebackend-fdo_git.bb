SUMMARY = "WPE's backend based on a Freedesktop.org stack."
HOMEPAGE = "https://github.com/Igalia/WPEBackend-fdo"
BUGTRACKER = "https://github.com/Igalia/WPEBackend-fdo/issues"

LICENSE = "CLOSED"
DEPENDS += "wpebackend glib-2.0 libxkbcommon wayland virtual/libgl"

SRCREV = "a437117577c260a43f6a85650c254186fbac0835"

SRC_URI = "git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master \
          "

S = "${WORKDIR}/git"


inherit cmake


FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/libWPEBackend-fdo.so ${libdir}/pkgconfig/wpebackend-fdo.pc"
INSANE_SKIP_${PN} ="dev-so"
