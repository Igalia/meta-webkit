SUMMARY = "A Wayland kiosk"
HOMEPAGE = "https://github.com/Hjdskes/cage"
BUGTRACKER = "https://github.com/Hjdskes/cage/issues"

SRC_URI = "https://github.com/Hjdskes/${PN}/releases/download/v${PV}/${PN}-${PV}.tar.gz file://scanner.patch"
SRC_URI[sha256sum] = "38a3e3968f00cc58fe1d9448e972cfac7d1efa30c48699f09032f264101a55ac"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3d06ce025701c9a0b391f15902ce8ed"

REQUIRED_DISTRO_FEATURES = "wayland"

DEPENDS += " \
	wlroots \
	wayland-native \
"

inherit meson features_check
