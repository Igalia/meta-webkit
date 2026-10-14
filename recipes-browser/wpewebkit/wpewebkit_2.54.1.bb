require wpewebkit.inc
require conf/include/devupstream.inc

# 310886@main added an unconditional <stdatomic.h> to libpas pas_utils.h. GCC
# resolves it to its C stdatomic.h when pas_utils.h is pulled into a C++ unit,
# which fails with "'_Atomic' does not name a type". Upstream fixed this for
# xcodebuild only (312138@main), the CMake build has no fix yet. Drop this
# patch once https://github.com/WebKit/WebKit/pull/74158 lands.
#
# WebDriver fails to build when both LOG_DISABLED and RELEASE_LOG_DISABLED are
# set, which is the case for a release build without journald. Drop this patch
# once https://github.com/WebKit/WebKit/pull/74228 lands.
SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0001-bmalloc-libpas-avoid-C-stdatomic-in-C-build.patch \
           "

SRC_URI[tarball.sha256sum] = "0de8bdfba011f9cd63ba9a9171fa6038dd2c08237894f4082abbb821f29d3fe9"

SRCBRANCH:class-devupstream = "webkitglib/2.54"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "537776966344c4982751692dd475c94124504271"
