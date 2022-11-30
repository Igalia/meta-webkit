SUMMARY = "OpenXR Software Development Kit (SDK) Project"
HOMEPAGE = "https://github.com/KhronosGroup/OpenXR-SDK"
BUGTRACKER = "https://github.com/KhronosGroup/OpenXR-SDK/issues"

inherit cmake pkgconfig

SRC_URI = "https://github.com/KhronosGroup/OpenXR-SDK/archive/refs/tags/release-${PV}.tar.gz"
SRC_URI[sha256sum] = "07e3e819af786c2a2bea16e8ec5243ce4e9d2876923112898fa4ea6dbd9bdd73"
S = "${WORKDIR}/OpenXR-SDK-release-${PV}"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "jsoncpp"

# The CMake system of this package is a bit convoluted. It tries to enable
# features automatically based on the dependencies it detects...
# It also has some support for using GLESv2 but that support only gets
# activated for Android and there is no manual option to enable it (without
# patching the CMake file to change the value of OPENGLES_INCOMPATIBLE).
#
# The following packageconfig options below allow to ensure that the required
# deps are present at configure time so their CMake system can autodetect those
# and enable the features accordingly.
PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'wayland x11 vulkan', d)}"
PACKAGECONFIG[x11] = ",,virtual/libgl virtual/libx11 libxcb libx11 libxrandr"
PACKAGECONFIG[wayland] = ",,virtual/egl wayland-native wayland wayland-protocols"
PACKAGECONFIG[vulkan] = ",,vulkan-headers vulkan-loader"
PACKAGECONFIG[tests] = "-DBUILD_TESTS=ON,-DBUILD_TESTS=OFF,"
