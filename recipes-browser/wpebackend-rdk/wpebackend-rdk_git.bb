SUMMARY = "Backend for WPE with specific support for embedded devices used on the RDK"
HOMEPAGE = "https://github.com/WebPlatformForEmbedded/WPEBackend-rdk"
BUGTRACKER = "https://github.com/WebPlatformForEmbedded/WPEBackend-rdk/issues"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/wayland/display.h;;beginline=5;endline=24;md5=b1c8cb6b0857048a21b33611f01c575a"

DEPENDS = "wpebackend glib-2.0 libinput"

PV = "1.20170824"
SRCREV = "f2aec84648dc9eb10c6aafbaf888151a9d120fce"

SRC_URI = " \
            git://github.com/WebPlatformForEmbedded/WPEBackend-rdk.git;protocol=https;branch=master \
            file://PR12.patch \
            file://PR13.patch \
          "

S = "${WORKDIR}/git"

inherit cmake pkgconfig


PACKAGECONFIG ?= "wayland"

# device specific backends
PACKAGECONFIG[intelce] = "-DUSE_BACKEND_INTEL_CE=ON -DUSE_HOLE_PUNCH_GSTREAMER=ON -DUSE_KEY_INPUT_HANDLING_LINUX_INPUT=ON,,intelce-display"
PACKAGECONFIG[nexus] = "-DUSE_BACKEND_BCM_NEXUS=ON -DUSE_HOLE_PUNCH_GSTREAMER=ON -DUSE_KEY_INPUT_HANDLING_LINUX_INPUT=ON,,broadcom-refsw"
PACKAGECONFIG[rpi] = "-DUSE_BACKEND_BCM_RPI=ON -DUSE_KEY_INPUT_HANDLING_LINUX_INPUT=ON,,userland"
PACKAGECONFIG[stm] = "-DUSE_BACKEND_STM=ON -DUSE_KEY_INPUT_HANDLING_LINUX_INPUT=OFF -DUSE_HOLE_PUNCH_GSTREAMER=ON,,libxkbcommon"

# Wayland selectors
PACKAGECONFIG[wayland] = "-DUSE_BACKEND_WAYLAND_EGL=ON -DUSE_KEY_INPUT_HANDLING_LINUX_INPUT=OFF,,wayland libxkbcommon"
PACKAGECONFIG[realtek] = "-DUSE_BACKEND_REALTEK=ON -DUSE_KEY_INPUT_HANDLING_LINUX_INPUT=OFF,,wayland libxkbcommon"
PACKAGECONFIG[westeros] = "-DUSE_BACKEND_WESTEROS=ON -DUSE_BACKEND_BCM_RPI=OFF -DUSE_KEY_INPUT_HANDLING_LINUX_INPUT=OFF -DUSE_HOLE_PUNCH_GSTREAMER=ON -DUSE_WESTEROS_SINK=ON,,wayland westeros libxkbcommon"
PACKAGECONFIG[bcm-weston] = "-DUSE_BACKEND_BCM_NEXUS_WAYLAND=ON,-DUSE_BACKEND_BCM_NEXUS_WAYLAND=OFF,,"

PACKAGECONFIG[westeros-mesa] = "-DUSE_BACKEND_WESTEROS_MESA=ON,,"

do_install() {

	install -d ${D}${libdir}
	install -m 0755 ${B}/libWPEBackend-*.so ${D}${libdir}/

}

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/libWPEBackend-default.so ${libdir}/libWPEBackend-rdk.so"
INSANE_SKIP ="dev-so"
