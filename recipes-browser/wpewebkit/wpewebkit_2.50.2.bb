require wpewebkit.inc
require conf/include/devupstream.inc

SRC_URI = "git://github.com/WebKit/WebKit;protocol=https;branch=webkitglib/2.50 \
           file://0001-Unreviewed-build-fix-after-298234.287-webkitglib-2.5.patch \
           file://0001-Workaround-compiler-bug-for-inlining.patch \
           file://0001-Revert-WTF-Modernize-wtf-MathExtras.h.patch \
           file://0002-Revert-Use-C-20-s-std-source_location-in-network-Res.patch \
           file://0003-Remove-usage-of-unsafe-buffer-usage-with-clang.patch \
           file://0004-Replace-usage-of-more-modern-C.patch \
           file://0006-Fix-dependent-iterator-types-for-gcc.patch \
           file://0007-Fix-WebKitColor-aggregate-initialization-in-tests.patch \
           "

SRCREV = "164005ba406dabcd36fe3e2f2f847cb6d6efb72c"
S = "${WORKDIR}/git"

SRCBRANCH:class-devupstream = "webkitglib/2.50"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "164005ba406dabcd36fe3e2f2f847cb6d6efb72c"