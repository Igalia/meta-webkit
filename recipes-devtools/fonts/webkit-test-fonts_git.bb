SUMMARY = "Test fonts used by WebKitGTK for layout and rendering validation"
DESCRIPTION = "This repository provides a collection of fonts used to perform \
               consistent layout and rendering tests in the WebKitGTK port. \
               It is mainly intended for automated test environments, \
               ensuring predictable font metrics and glyph coverage during \
               cross-platform WebKitGTK testing."
HOMEPAGE = "https://github.com/WebKitGTK/webkitgtk-test-fonts"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.dejavu;md5=b48ab4e9977f6f7d9eb9481bb69a219d"

PR = "r0"

BPV = "0.0.8"
PV = "${BPV}"

SRC_URI = "git://github.com/WebKitGTK/webkitgtk-test-fonts.git;protocol=https;branch=master"
SRCREV = "f6382ed93932cca128c8d9edec3088f85a7592d9"

# nooelint: oelint.task.noanonpython - required for backward compatibility with scarthgap
python __anonymous() {
    if not d.getVar('UNPACKDIR'):
        d.setVar('S', d.getVar('WORKDIR') + '/git')
}

do_configure() {
}

do_compile() {
}

do_install() {
   cd ${S}
   make DESTDIR="${D}${datadir}" install
}

# nooelint: oelint.var.filesoverride - this must be revisited
FILES:${PN} = " \
${datadir}/webkitgtk-test-fonts/* \
"
