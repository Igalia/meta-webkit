DESCRIPTION = "This provides a recipe for running run-benchmark and \
               browserperfdash-benchmark perf test scripts"

SRCREV = "f48310dcbab76037985cc0b2eeb3caa69e5b4c45"
SRC_URI = "git://github.com/Igalia/browserperfrunner.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://browserperfdash-benchmark;md5=0447dc08401181d17386fac95e7524f7"


PACKAGES = "${PN}"

# Note: this recipe depends on meta-openembedded/meta-python for python-psutil
# And the dromaeo test needs the crc32 binary that is provided by libarchive-zip-perl
RDEPENDS_${PN} = " curl make patch perl procps psmisc python python-misc \
                   python-modules python-psutil python-setuptools \
                   gobject-introspection python-pygobject gtk+3 ruby \
                   subversion libarchive-zip-perl"

inherit python-dir

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}
    install -m 0755 ${S}/browserperfdash-benchmark ${D}${bindir}
    install -m 0755 ${S}/run-benchmark ${D}${bindir}
    cp -dr --preserve=mode,timestamp ${S}/webkitpy ${D}${PYTHON_SITEPACKAGES_DIR}/
}

FILES_${PN} = "${bindir}/* ${PYTHON_SITEPACKAGES_DIR}/*"
