require cairo.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=e73e999e0c72b5ac9012424fa157ad77"

# This is cairo 1.14.0 with some patches required for webkitforwayland
# The recipe is based on cairo 1.14.2 from oe-core
GITCOMMIT = "dd8e6a461d53add34008ea9f33e7f1dba5d2c5cb"
SRC_URI = "https://github.com/WebKitForWayland/cairo/archive/${GITCOMMIT}.tar.gz"

SRC_URI[md5sum] = "08e82e91c69e6bf61bb733477024591a"
SRC_URI[sha256sum] = "ef46344cce5d8c5f919f90568db491f46f0cea58de8d92c7adda1f762fb35e37"

S = "${WORKDIR}/cairo-${GITCOMMIT}/"

PACKAGES =+ "cairo-gobject cairo-script-interpreter cairo-perf-utils"

SUMMARY_${PN} = "The Cairo 2D vector graphics library"
DESCRIPTION_${PN} = "Cairo is a multi-platform library providing anti-aliased \
vector-based rendering for multiple target backends. Paths consist \
of line segments and cubic splines and can be rendered at any width \
with various join and cap styles. All colors may be specified with \
optional translucence (opacity/alpha) and combined using the \
extended Porter/Duff compositing algebra as found in the X Render \
Extension."

SUMMARY_cairo-gobject = "The Cairo library GObject wrapper library"
DESCRIPTION_cairo-gobject = "A GObject wrapper library for the Cairo API."

SUMMARY_cairo-script-interpreter = "The Cairo library script interpreter"
DESCRIPTION_cairo-script-interpreter = "The Cairo script interpreter implements \
CairoScript.  CairoScript is used by tracing utilities to enable the ability \
to replay rendering."

DESCRIPTION_cairo-perf-utils = "The Cairo library performance utilities"

FILES_${PN} = "${libdir}/libcairo.so.*"
FILES_${PN}-dev += "${libdir}/cairo/*.so"
FILES_${PN}-gobject = "${libdir}/libcairo-gobject.so.*"
FILES_${PN}-script-interpreter = "${libdir}/libcairo-script-interpreter.so.*"
FILES_${PN}-perf-utils = "${bindir}/cairo-trace ${libdir}/cairo/*.la ${libdir}/cairo/libcairo-trace.so.*"

do_configure_prepend() {
	touch ${S}/boilerplate/Makefile.am.features
	touch ${S}/src/Makefile.am.features
	touch ${S}/ChangeLog
}

do_install_append () {
	rm -rf ${D}${bindir}/cairo-sphinx
	rm -rf ${D}${libdir}/cairo/cairo-fdr*
	rm -rf ${D}${libdir}/cairo/cairo-sphinx*
	rm -rf ${D}${libdir}/cairo/.debug/cairo-fdr*
	rm -rf ${D}${libdir}/cairo/.debug/cairo-sphinx*
}
