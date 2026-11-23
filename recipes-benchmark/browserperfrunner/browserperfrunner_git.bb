SUMMARY = "Browser performance benchmark runner scripts"
DESCRIPTION = "This provides a recipe for running run-benchmark and \
               browserperfdash-benchmark perf test scripts"
HOMEPAGE = "https://github.com/Igalia/browserperfrunner"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://browserperfdash-benchmark;md5=5de144702cd7cf4dfde864c5174fb818"

# destsuffix keeps the unpack dir matching the default S (${WORKDIR|UNPACKDIR}/${BP})
# on releases older than whinlatter, where the git fetcher unpacks to 'git' instead
SRC_URI = "git://github.com/psaavedra/browserperfrunner.git;protocol=https;branch=main;destsuffix=${BP}"
SRCREV = "b9eabbd050f84757a6bce40648aae2327aadbf61"

inherit python3-dir

PACKAGES = "${PN}"

FILES:${PN} += "${PYTHON_SITEPACKAGES_DIR}"

# benchmark_builder invokes svn, patch and tar to fetch and prepare the
# benchmark sources, github_downloader calls /usr/bin/curl, and the plan
# create scripts need make (dromaeo), perl (sunspider), ruby (jetstream)
# and python (kraken). The linux browser driver uses python3-pygobject
# with the Gtk 3.0 typelib to query the screen resolution.
# Note: the dromaeo plan additionally needs the crc32 tool (Archive::Zip),
# which is included in this layer as libarchive-zip-perl.
#
# The python3-* modules below provide what webkitcorepy's AutoInstall would
# otherwise pip-download on first import (the autoinstaller is disabled by
# do_install, see there), including the twisted stack used by the default
# http server of the webserver benchmark runner. python3-tomli, python3-twisted,
# python3-constantly, python3-hyperlink, python3-incremental and
# python3-zopeinterface come from meta-python. dnslib has no recipe, but it
# is only imported by webkitpy/layout_tests, which the benchmark entry
# points never reach.
RDEPENDS:${PN} = " \
    curl \
    gobject-introspection \
    gtk+3 \
    libarchive-zip-perl \
    make \
    patch \
    perl \
    procps \
    psmisc \
    python3-attrs \
    python3-bcrypt \
    python3-certifi \
    python3-cffi \
    python3-chardet \
    python3-constantly \
    python3-core \
    python3-cryptography \
    python3-hyperlink \
    python3-idna \
    python3-incremental \
    python3-modules \
    python3-packaging \
    python3-psutil \
    python3-pycparser \
    python3-pygobject \
    python3-pyopenssl \
    python3-pyparsing \
    python3-pysocks \
    python3-requests \
    python3-service-identity \
    python3-setuptools \
    python3-setuptools-scm \
    python3-six \
    python3-tomli \
    python3-twisted \
    python3-typing-extensions \
    python3-urllib3 \
    python3-wheel \
    python3-zopeinterface \
    ruby \
    subversion \
"

# Like upstream's webkitpy/autoinstalled/twisted.py, skip bcrypt on 32-bit
# arm: building it needs a cargo/rust toolchain and twisted only uses it
# for conch/ssh, which the benchmark http server never touches.
# nooelint: oelint.vars.specific
RDEPENDS:${PN}:remove:arm = "python3-bcrypt"

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}
    install -m 0755 ${S}/browserperfdash-benchmark ${D}${bindir}
    install -m 0755 ${S}/run-benchmark ${D}${bindir}
    # Disable webkitcorepy's AutoInstall: it hooks sys.meta_path ahead of the
    # standard finders and pip-downloads its own copy of every registered
    # module even when the system provides it. With it disabled, imports
    # fall through to the python3-* packages from RDEPENDS. Export
    # DISABLE_WEBKITCOREPY_AUTOINSTALLER=0 to revert to auto-downloading.
    sed -i '1a import os; os.environ.setdefault("DISABLE_WEBKITCOREPY_AUTOINSTALLER", "1")' \
        ${D}${bindir}/browserperfdash-benchmark ${D}${bindir}/run-benchmark
    # webkitpy/__init__.py resolves the bundled WebKit libraries
    # (webkitcorepy, webkitscmpy, webkitbugspy, webkitexpectationspy) from a
    # 'libraries' directory next to the webkitpy package.
    tar -C ${S} -cf - webkitpy libraries | tar -C ${D}${PYTHON_SITEPACKAGES_DIR} --no-same-owner -xf -
}
