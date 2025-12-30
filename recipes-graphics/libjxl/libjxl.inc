SUMMARY = "JPEG XL reference implementation"
DESCRIPTION = "Reference implementation of JPEG XL (encoder and decoder), \
               called libjxl. This software library is used by many \
               applications that support JPEG XL."
HOMEPAGE = "https://github.com/libjxl/libjxl/"
BUGTRACKER = "https://github.com/libjxl/libjxl/issues"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6a905a337cc228a1f68f0b5416f52a7f"

DEPENDS:append = " brotli highway libpng lcms"

SRC_URI = "git://github.com/libjxl/libjxl.git;branch=v0.8.x;protocol=https;rev=c27d499263435ac77007174e0f1cf54557cff23a \
           file://fix-riscv-build-add-missing-atomic-include.patch \
           file://CVE-2024-11403.patch \
           "

# nooelint: oelint.task.noanonpython - required for backward compatibility with scarthgap
python __anonymous() {
    if not d.getVar('UNPACKDIR'):
        d.setVar('S', d.getVar('WORKDIR') + '/git')
}

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
    -DJPEGXL_ENABLE_SKCMS=OFF \
    -DJPEGXL_BUNDLE_LIBPNG=OFF \
    -DJPEGXL_STATIC=OFF \
    -DJPEGXL_WARNINGS_AS_ERRORS=OFF \
    -DJPEGXL_FORCE_SYSTEM_BROTLI=ON \
    -DJPEGXL_FORCE_SYSTEM_GTEST=ON \
    -DJPEGXL_FORCE_SYSTEM_HWY=ON \
    -DJPEGXL_FORCE_SYSTEM_LCMS2=ON \
"
inherit cmake pkgconfig

# nooelint: oelint.vars.specific - ignored for convenience
CXXFLAGS:append:arm = " -mfp16-format=ieee"

