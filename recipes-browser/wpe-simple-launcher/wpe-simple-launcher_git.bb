SUMMARY = "Simple WPE-based web launcher"
DESCRIPTION = "On-device WPEWebKit launcher that opens a URL and exposes a FIFO control channel through the wpe-ctl helper."
HOMEPAGE = "https://github.com/psaavedra/wpe-simple-launcher"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dd93f6e0496294f589c3d561f96ffee4"

inherit meson pkgconfig

DEPENDS += "glib-2.0-native wpewebkit"

SRC_URI = "git://github.com/psaavedra/wpe-simple-launcher.git;protocol=https;branch=main \
           file://wpe-ctl \
           file://wpe-exported-wayland \
          "
SRCREV = "522488025d1e68d039667bd897b3e8f4ee820061"

S = "${WORKDIR}/git"

do_install:append() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/wpe-simple-launcher ${D}${bindir}/wpe-simple-launcher
    install -m 0755 ${WORKDIR}/wpe-ctl ${D}${bindir}/wpe-ctl
    install -m 0755 ${WORKDIR}/wpe-exported-wayland ${D}${bindir}/wpe-exported-wayland
}

