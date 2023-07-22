SUMMARY = "Efficient and performance-portable SIMD"
HOMEPAGE = "https://github.com/google/highway/"
BUGTRACKER = "https://github.com/google/highway/issues"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/google/highway.git;protocol=https;branch=master \
           file://pr_1589.patch"
SRCREV = "46e365d6770f5d7a4240d8ac9d8e928a520478ea"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2b42edef8fa55315f34f2370b4715ca9"

EXTRA_OECMAKE = " -DBUILD_TESTING=OFF \
    -DHWY_WARNINGS_ARE_ERRORS=OFF \
    -DHWY_ENABLE_EXAMPLES=OFF \
    -DHWY_ENABLE_INSTALL=ON \
    -DBUILD_SHARED_LIBS=ON "

CXXFLAGS:append:arm = " -mfp16-format=ieee"

inherit cmake
