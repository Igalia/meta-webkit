SUMMARY = "Efficient and performance-portable SIMD"
HOMEPAGE = "https://github.com/google/highway/"
BUGTRACKER = "https://github.com/google/highway/issues"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/google/highway.git;protocol=https;branch=master"
SRCREV = "e69083a12a05caf037cabecdf1b248b7579705a5"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2b42edef8fa55315f34f2370b4715ca9"

EXTRA_OECMAKE = " -DBUILD_TESTING=OFF \
    -DHWY_WARNINGS_ARE_ERRORS=OFF \
    -DHWY_ENABLE_EXAMPLES=OFF \
    -DHWY_ENABLE_INSTALL=ON"

CXXFLAGS:append:arm = " -mfp16-format=ieee"

inherit cmake
