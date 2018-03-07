SUMMARY = "WPE's backend based on a Freedesktop.org stack."
HOMEPAGE = "https://github.com/Igalia/WPEBackend-fdo"
BUGTRACKER = "https://github.com/Igalia/WPEBackend-fdo/issues"

LICENSE = "CLOSED"
DEPENDS += "wpebackend glib-2.0 libxkbcommon wayland virtual/libgl"

SRCREV = "9283e0ed6cedaa61fd89a3ae92efe75d6c122f5a"

SRC_URI = " \
            git://github.com/Igalia/WPEBackend-fdo.git;protocol=https;branch=master \
            file://removes-unnecessary-include-eglmesaext.patch \
          "

S = "${WORKDIR}/git"


inherit cmake


FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/libWPEBackend-fdo.so ${libdir}/pkgconfig/wpebackend-fdo.pc"
INSANE_SKIP_${PN} ="dev-so"
