SUMMARY = "Lossless compression library and tool"
DESCRIPTIOM = "Brotli is a generic-purpose lossless compression algorithm \
that it is similar in speed to deflate but offers more dense compression."
HOMEPAGE = "https://github.com/google/brotli"
BUGTRACKER = "https://github.com/google/brotli/issues"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=941ee9cd1609382f946352712a319b4b"
UPSTREAM_CHECK_URI = "https://github.com/google/brotli/releases"

SRC_URI = "https://github.com/google/brotli/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "1728ace46c6624d9548ca710e8e9a952"
SRC_URI[sha256sum] = "2268a3dff1cc36e18549e89a51ee0cd9513908a977d56d6a1f9d4c61c2af37c3"

inherit cmake lib_package
