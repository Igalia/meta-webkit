require wpewebkit.inc

DEFAULT_PRERENCE = "-1"

SVNBRANCH = "trunk"
SVNREV ?= "234795"

# To enable this recipe set on local.conf
# PREFERRED_VERSION_wpewebkit = "1.trunk%"
# To select a different SVN version you can also set on local.conf
# SVNREV = "$numberofsvnrev"

PV = "1.trunk-${SVNREV}"

SRC_URI = " \
    svn://svn.webkit.org/repository/webkit;module=${SVNBRANCH};rev=${SVNREV};protocol=https \
"
S = "${WORKDIR}/${SVNBRANCH}"
