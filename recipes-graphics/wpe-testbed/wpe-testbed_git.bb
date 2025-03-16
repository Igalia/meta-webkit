DESCRIPTION = "WPE Testbed Application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fc9c8be99e989ccbabacb74e024806d9"

inherit cmake pkgconfig

DEPENDS = "glib-2.0-native wayland-native libdrm virtual/libgbm virtual/egl virtual/libgles2 wayland"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

SRCREV = "d7ac4675d0392bf843526700fdae9f0fd4c84756"
SRC_URI = "git://git@github.com/Igalia/wpe-testbed-wayland.git;protocol=ssh;branch=main"

S = "${WORKDIR}/git"

EXTRA_OECMAKE = ""

