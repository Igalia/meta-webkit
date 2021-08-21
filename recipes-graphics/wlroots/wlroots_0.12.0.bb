SUMMARY = "A modular Wayland compositor library"
HOMEPAGE = "https://github.com/swaywm/wlroots"
BUGTRACKER = "https://github.com/swaywm/wlroots/issues"

SRC_URI = "https://github.com/swaywm/${PN}/releases/download/${PV}/wlroots-${PV}.tar.gz file://mesonver.patch"
SRC_URI[sha256sum] = "c9e9f4f6d2f526d0b2886daf3ec37e64831773059aa669fb98a88522a1626bdb"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7578fad101710ea2d289ff5411f1b818"

REQUIRED_DISTRO_FEATURES = "wayland"

DEPENDS += " \
	libdrm \
	libinput \
	libxkbcommon \
	pixman \
	seatd \
	virtual/libgbm \
	wayland \
	wayland-native \
	wayland-protocols \
"

PACKAGECONFIG[gles2] = "-Drenderers=gles2"
PACKAGECONFIG[x11-backend] = "-Dx11-backend=enabled,-Dx11-backend=disabled,xcb-util-renderutil"
PACKAGECONFIG[xwayland] = "-Dxwayland=enabled,-Dxwayland=disabled,xserver-xorg xcb-util-wm"

PACKAGECONFIG ?= " \
	gles2 \
"

inherit meson pkgconfig features_check
