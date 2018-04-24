require wpewebkit.inc

# There are still no official tarballs for WPE upstream.
# So instead of a tarball we currently fetch the stable branch of the upstream repository.
SVNREV = "230477"
# Note: WPE and GTK WebKit ports share the same stable branches on SVN.
SVNBRANCH = "releases/WebKitGTK/webkit-2.20"
SRC_URI = " \
    svn://svn.webkit.org/repository/webkit;module=${SVNBRANCH};rev=${SVNREV};protocol=https \
"
S = "${WORKDIR}/${SVNBRANCH}"
