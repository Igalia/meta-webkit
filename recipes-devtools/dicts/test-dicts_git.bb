LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.en_US;md5=370dfc0dcc9918290a76eeb1e761f377"

PR = "r0"

BPV = "0.0.1"
PV = "${BPV}"
SRCREV = "a63aa52f09ddbf2532304a5751d22e5712299b0d"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://github.com/mrobinson/webkitgtk-test-dicts.git;protocol=https;branch=master \
    "

do_configure() {
}

do_compile() {
}

do_install() {
   cd ${S}
   export DESTDIR=${D}
   JHBUILD_PREFIX=""
   make install
}

FILES_${PN} = " \
/webkitgtk-test-dicts/* \
"
