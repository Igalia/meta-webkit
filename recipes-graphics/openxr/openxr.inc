SUMMARY = "OpenXR Software Development Kit (SDK) Project"
HOMEPAGE = "https://github.com/KhronosGroup/OpenXR-SDK"
BUGTRACKER = "https://github.com/KhronosGroup/OpenXR-SDK/issues"

SRC_URI = "https://github.com/KhronosGroup/OpenXR-SDK/archive/refs/tags/release-${PV}.tar.gz"
SRC_URI[sha256sum] = "79c2893eaa868bf1ef5df035a423802342b15b14341d45d75447af49b10d1461"

S = "${WORKDIR}/OpenXR-SDK-release-${PV}"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
DEPENDS = "virtual/egl jsoncpp libxkbcommon"

EXTRA_OECMAKE = " -DBUILD_TESTS=OFF"

inherit cmake
