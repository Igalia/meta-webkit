DESCRIPTION = "This provides a recipe for running run-benchmark and \
               browserperfdash-benchmark perf test scripts"

SRCREV = "f48310dcbab76037985cc0b2eeb3caa69e5b4c45"
SRC_URI = "git://github.com/Igalia/browserperfrunner.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://browserperfdash-benchmark;md5=0447dc08401181d17386fac95e7524f7"


PACKAGES = "${PN}"

# Note: this recipe depends on meta-openembedded/meta-python for python-psutil
# And the dromaeo test needs the crc32 binary that is provided by libarchive-zip-perl
RDEPENDS:${PN} = " curl make patch perl procps psmisc python python-misc \
                   python-modules python-psutil python-setuptools \
                   gobject-introspection python-pygobject gtk+3 ruby \
                   subversion libarchive-zip-perl"

# This recipe still requires python2.
# So on Yocto dunfell and later its needed to use meta-python2
# Port to python3 tracked at https://github.com/Igalia/browserperfrunner/issues/3
inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "python-dir", "", d)}

python() {
    if "meta-python2" not in d.getVar("BBFILE_COLLECTIONS").split():
        raise bb.parse.SkipRecipe("Requires meta-python2 to be present.")
}

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}
    install -m 0755 ${S}/browserperfdash-benchmark ${D}${bindir}
    install -m 0755 ${S}/run-benchmark ${D}${bindir}
    cp -dr --preserve=mode,timestamp ${S}/webkitpy ${D}${PYTHON_SITEPACKAGES_DIR}/
}

FILES:${PN} = "${bindir}/* ${PYTHON_SITEPACKAGES_DIR}/*"
