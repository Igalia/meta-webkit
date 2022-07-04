SUMMARY = "JPEG XL reference implementation"
HOMEPAGE = "https://github.com/libjxl/libjxl/"
BUGTRACKER = "https://github.com/libjxl/libjxl/issues"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/libjxl/libjxl.git;branch=v0.6.x;protocol=https;rev=a205468bc5d3a353fb15dae2398a101dff52f2d3 \
           git://skia.googlesource.com/skcms;branch=main;protocol=https;rev=64374756e03700d649f897dbd98c95e78c30c7da;destsuffix=git/third_party/skcms \
           git://github.com/lvandeve/lodepng;branch=master;protocol=https;rev=8c6a9e30576f07bf470ad6f09458a2dcd7a6a84a;destsuffix=git/third_party/lodepng \
"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6a905a337cc228a1f68f0b5416f52a7f"
DEPENDS = "brotli highway"

EXTRA_OECMAKE = " -DBUILD_TESTING=OFF \
    -DJPEGXL_ENABLE_FUZZERS=OFF \
    -DJPEGXL_ENABLE_DEVTOOLS=OFF \
    -DJPEGXL_ENABLE_TOOLS=OFF \
    -DJPEGXL_ENABLE_MANPAGES=OFF \
    -DJPEGXL_ENABLE_BENCHMARK=OFF \
    -DJPEGXL_ENABLE_EXAMPLES=OFF \
    -DJPEGXL_ENABLE_JNI=OFF \
    -DJPEGXL_ENABLE_VIEWERS=OFF \
    -DJPEGXL_ENABLE_TCMALLOC=OFF \
    -DJPEGXL_ENABLE_PLUGINS=OFF \
    -DJPEGXL_ENABLE_COVERAGE=OFF \
    -DJPEGXL_ENABLE_PROFILER=OFF \
    -DJPEGXL_ENABLE_TRANSCODE_JPEG=OFF \
    -DJPEGXL_ENABLE_SJPEG=OFF \
    -DJPEGXL_STATIC=OFF \
    -DJPEGXL_WARNINGS_AS_ERRORS=OFF \
    -DJPEGXL_ENABLE_SKCMS=ON \
    -DJPEGXL_FORCE_SYSTEM_BROTLI=ON \
    -DJPEGXL_FORCE_SYSTEM_GTEST=ON \
    -DJPEGXL_FORCE_SYSTEM_HWY=ON"

inherit cmake pkgconfig

CXXFLAGS:append:arm = " -mfp16-format=ieee"

