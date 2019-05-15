SUMMARY = "Lossless compression library and tool"
DESCRIPTIOM = "Brotli is a generic-purpose lossless compression algorithm \
that it is similar in speed to deflate but offers more dense compression."
HOMEPAGE = "https://github.com/google/brotli"
BUGTRACKER = "https://github.com/google/brotli/issues"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=941ee9cd1609382f946352712a319b4b"
UPSTREAM_CHECK_URI = "https://github.com/google/brotli/releases"

SRC_URI = "https://github.com/google/brotli/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "5d3c45e033d31d1c986b59e16421ba3c"
SRC_URI[sha256sum] = "3d5bedd48edb909fe3b87cb99f7d139b987ef6f1616b7e22d74e928270a2fd20"

inherit cmake lib_package
