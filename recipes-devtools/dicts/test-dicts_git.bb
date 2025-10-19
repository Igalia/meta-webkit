SUMMARY = "Test dictionaries for WebKitGTK layout and rendering checks"
DESCRIPTION = "This package provides English hyphenation dictionaries used by WebKitGTK regression tests to validate text layout and hyphenation behavior across locales."
HOMEPAGE = "https://github.com/mrobinson/webkitgtk-test-dicts"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.en_US;md5=370dfc0dcc9918290a76eeb1e761f377"

PR = "r0"

BPV = "0.0.1"
PV = "${BPV}"

SRC_URI = "git://github.com/mrobinson/webkitgtk-test-dicts.git;protocol=https;branch=master"
SRCREV = "a63aa52f09ddbf2532304a5751d22e5712299b0d"

# nooelint: oelint.task.noanonpython - required for backward compatibility with scarthgap
python __anonymous() {
    if not d.getVar('UNPACKDIR'):
        d.setVar('S', d.getVar('WORKDIR') + '/git')
}

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${datadir}/webkitgtk-test-dicts
    cd ${S}
    make DESTDIR="${D}${datadir}" install
}

FILES:${PN} += "${datadir}/webkitgtk-test-dicts/"
