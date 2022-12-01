SUMMARY = "Backend for WPE with specific support for embedded devices used on the RDK"
HOMEPAGE = "https://github.com/WebPlatformForEmbedded/WPEBackend-rdk"
BUGTRACKER = "https://github.com/WebPlatformForEmbedded/WPEBackend-rdk/issues"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://src/wayland/display.h;;beginline=5;endline=24;md5=b1c8cb6b0857048a21b33611f01c575a"

SRC_URI = "git://github.com/WebPlatformForEmbedded/WPEBackend-rdk.git;protocol=git;branch=master"

PROVIDES += "virtual/wpebackend"
RPROVIDES:${PN} += "virtual/wpebackend"

DEPENDS = "libwpe virtual/egl glib-2.0 libxkbcommon xkeyboard-config libinput libudev"

inherit cmake pkgconfig


PACKAGECONFIG ?= "wayland"

# device specific backends
PACKAGECONFIG[intelce] = "-DUSE_BACKEND_INTEL_CE=ON,,intelce-display"
PACKAGECONFIG[nexus] = "-DUSE_BACKEND_BCM_NEXUS=ON,,broadcom-refsw"
PACKAGECONFIG[rpi] = "-DUSE_BACKEND_BCM_RPI=ON,,userland"
PACKAGECONFIG[stm] = "-DUSE_BACKEND_STM=ON,,"
PACKAGECONFIG[imx6] = "-DUSE_BACKEND_VIV_IMX6_EGL=ON,,imx-gpu-viv"

# Wayland selectors
PACKAGECONFIG[wayland] = "-DUSE_BACKEND_WAYLAND_EGL=ON,,wayland"
PACKAGECONFIG[realtek] = "-DUSE_BACKEND_REALTEK=ON,,wayland"
PACKAGECONFIG[westeros] = "-DUSE_BACKEND_WESTEROS=ON,,wayland westeros"
PACKAGECONFIG[bcm-weston] = "-DUSE_BACKEND_BCM_NEXUS_WAYLAND=ON,,,"
PACKAGECONFIG[westeros-mesa] = "-DUSE_BACKEND_WESTEROS_MESA=ON,,"

do_install() {
	install -d ${D}${libdir}
	install -m 0755 ${B}/libWPEBackend-*.so ${D}${libdir}/
}

FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/libWPEBackend-default.so ${libdir}/libWPEBackend-rdk.so"
INSANE_SKIP ="dev-so"
