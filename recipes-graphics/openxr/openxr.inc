SUMMARY = "OpenXR Software Development Kit (SDK) Project"
HOMEPAGE = "https://github.com/KhronosGroup/OpenXR-SDK"
BUGTRACKER = "https://github.com/KhronosGroup/OpenXR-SDK/issues"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://github.com/KhronosGroup/OpenXR-SDK/archive/refs/tags/release-${PV}.tar.gz \
           file://0001-Fix-GCC-11-builds.patch \
          "
SRC_URI[sha256sum] = "b32703d30b4f40f5cb1a16e7242e3587ad5b3b47893c90dce884b162c5ca0e02"

S = "${WORKDIR}/OpenXR-SDK-release-${PV}"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
DEPENDS = "virtual/egl jsoncpp libxkbcommon"

EXTRA_OECMAKE = " -DBUILD_TESTS=OFF"

inherit cmake
