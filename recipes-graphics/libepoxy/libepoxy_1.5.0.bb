SUMMARY = "OpenGL function pointer management library"
HOMEPAGE = "https://github.com/anholt/libepoxy/"
SECTION = "libs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=58ef4c80d401e07bd9ee8b6b58cf464b"

SRC_URI = "https://github.com/anholt/${BPN}/releases/download/${PV}/${BP}.tar.xz"
SRC_URI[md5sum] = "63fe3847789258254dcd7e3fdb9e7f5e"
SRC_URI[sha256sum] = "4c94995398a6ebf691600dda2e9685a0cac261414175c2adf4645cdfab42a5d5"
UPSTREAM_CHECK_URI = "https://github.com/anholt/libepoxy/releases"

inherit autotools pkgconfig distro_features_check

DEPENDS = "util-macros-native"
REQUIRED_DISTRO_FEATURES = "opengl"

PACKAGECONFIG[egl] = "--enable-egl, --disable-egl, virtual/egl"
PACKAGECONFIG[x11] = "--enable-glx, --disable-glx, virtual/libx11"
PACKAGECONFIG ??= "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} egl"
