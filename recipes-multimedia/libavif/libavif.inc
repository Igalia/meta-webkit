SUMMARY = "This library aims to be a friendly, portable C implementation of the AV1 Image File Format"
HOMEPAGE = "https://github.com/AOMediaCodec/libavif"
BUGTRACKER = "https://github.com/AOMediaCodec/libavif/issues"

SRC_URI = "https://github.com/AOMediaCodec/libavif/archive/refs/tags/v${PV}.tar.gz"
SRC_URI[sha256sum] = "ea1603fc18e7dd20cf01f0b405156576886ecb5df84db8c0e87187cd2f8a00f4"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eb2c3b8fcc34ed603e622fced328988f"

inherit cmake

PACKAGECONFIG ??= "dav1d"
PACKAGECONFIG[dav1d] = "-DCMAKE_BUILD_TYPE=ON,-DCMAKE_BUILD_TYPE=OFF,dav1d"

