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
           file://0002-WebDriver-Fix-build-when-logging-is-disabled.patch \
           "

SRC_URI[tarball.sha256sum] = "efa9bcc3cb891c2d88f50eec710d9ccee71cbdf1040420361eb98c17355eb452"

SRCBRANCH:class-devupstream = "webkitglib/2.54"
SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=${SRCBRANCH}"
SRCREV:class-devupstream = "73f39d84ea9d4071994214373efbde3665402b05"
