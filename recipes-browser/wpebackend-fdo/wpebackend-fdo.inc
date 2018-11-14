SUMMARY = "WPE's backend based on a freedesktop.org stack."
HOMEPAGE = "https://github.com/Igalia/WPEBackend-fdo"
BUGTRACKER = "https://github.com/Igalia/WPEBackend-fdo/issues"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=1f62cef2e3645e3e74eb05fd389d7a66"
DEPENDS = "glib-2.0 libxkbcommon wayland virtual/egl"
PROVIDES += "virtual/wpebackend"
RPROVIDES_${PN} += "virtual/wpebackend"

inherit cmake

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/libWPEBackend-fdo-0.1.so"
INSANE_SKIP_${PN} ="dev-so"
