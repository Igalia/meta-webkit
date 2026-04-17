require wpewebkit.inc
require conf/include/devupstream.inc

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-Unreviewed-build-fix-after-298234.287-webkitglib-2.5.patch \
           file://0001-Workaround-compiler-bug-for-inlining.patch \
           file://0001-Revert-WTF-Modernize-wtf-MathExtras.h.patch \
           file://0002-Revert-Use-C-20-s-std-source_location-in-network-Res.patch \
           file://0003-Remove-usage-of-unsafe-buffer-usage-with-clang.patch \
           file://0004-Replace-usage-of-more-modern-C.patch \
           file://0006-Fix-dependent-iterator-types-for-gcc.patch \
           file://0007-Fix-WebKitColor-aggregate-initialization-in-tests.patch \
           "

SRC_URI[tarball.sha256sum] = "51a0fe5dc1fc690b839adaf473b4b70090c3ed316b21b74a35c07d6d2ef28536"

SRCBRANCH:class-devupstream = "webkitglib/2.50"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "7b746d3cafa3784c52d14543a424ef8ef9a2a07d"
