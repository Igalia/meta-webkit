LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.dejavu;md5=b48ab4e9977f6f7d9eb9481bb69a219d"

PR = "r0"

BPV = "0.0.8"
PV = "${BPV}"
SRCREV = "f6382ed93932cca128c8d9edec3088f85a7592d9"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://github.com/WebKitGTK/webkitgtk-test-fonts.git;protocol=https;branch=master \
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
/webkitgtk-test-fonts/* \
"
