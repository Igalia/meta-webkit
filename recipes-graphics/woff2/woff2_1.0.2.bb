SUMMARY = "The Web Open Font Format file format 2.0 (WOFF2)"
DESCRIPTION = "The Web Open Font Format (WOFF) is a font format for use in web pages. \
The new WOFF 2.0 Web Font compression format offers a 30% average gain over WOFF 1.0. \
It is a World Wide Web Consortium (W3C) recommendation."
HOMEPAGE = "https://github.com/google/woff2"
BUGTRACKER = "https://github.com/google/woff2/issues"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=027c71da9e4664fdf192e6ec615f4d18"
UPSTREAM_CHECK_URI = "https://github.com/google/woff2/releases"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS = "brotli"

# Backward compatibility with scarthgap
python __anonymous() {
    if not d.getVar('UNPACKDIR'):
        d.setVar('S', d.getVar('WORKDIR') + '/git')
}

SRC_URI = "git://github.com/google/woff2.git;branch=master;protocol=https \
           file://0001-Fix-compilation-errors-by-including-cstdint.patch"
SRCREV = "1bccf208bca986e53a647dfe4811322adb06ecf8"

inherit cmake lib_package
