SUMMARY = "The Web Open Font Format file format 2.0 (WOFF2)"
DESCRIPTIOM = "The Web Open Font Format (WOFF) is a font format for use in web pages. \
The new WOFF 2.0 Web Font compression format offers a 30% average gain over WOFF 1.0. \
It is a World Wide Web Consortium (W3C) recommendation."
HOMEPAGE = "https://github.com/google/woff2"
BUGTRACKER = "https://github.com/google/woff2/issues"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=027c71da9e4664fdf192e6ec615f4d18"
UPSTREAM_CHECK_URI = "https://github.com/google/woff2/releases"

DEPENDS = "brotli"

SRC_URI = "https://github.com/google/woff2/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "793c8844845351cb80730a74937e411b"
SRC_URI[sha256sum] = "add272bb09e6384a4833ffca4896350fdb16e0ca22df68c0384773c67a175594"

inherit cmake lib_package
