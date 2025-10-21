SUMMARY = "Backend for WPE with specific support for embedded devices used on the RDK"
DESCRIPTION = "WPEBackend-rdk serves as a modular backend for the WPE WebKit port, providing platform-specific integration for embedded devices, especially within the RDK ecosystem. It supports a variety of hardware targets through configurable backends, including Wayland-EGL, Westeros, Broadcom (Nexus, RPi), NXP i.MX6 (VIV), and a headless mode. The backend also integrates with multiple input handling systems like libinput and Wayland to process user input."
HOMEPAGE = "https://github.com/WebPlatformForEmbedded/WPEBackend-rdk"
BUGTRACKER = "https://github.com/WebPlatformForEmbedded/WPEBackend-rdk/issues"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://src/wayland/display.h;;beginline=5;endline=24;md5=b1c8cb6b0857048a21b33611f01c575a"

DEPENDS:append = " glib-2.0 libwpe libxkbcommon virtual/egl xkeyboard-config"

inherit cmake pkgconfig

PROVIDES += "virtual/wpebackend"

PACKAGECONFIG ?= "wayland input-libinput input-udev"

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

# Input backends
PACKAGECONFIG[input-libinput] = "-DUSE_INPUT_LIBINPUT=ON,-DUSE_INPUT_LIBINPUT=OFF,libinput"
PACKAGECONFIG[input-udev] = "-DUSE_INPUT_UDEV=ON,-DUSE_INPUT_UDEV=OFF,udev"
PACKAGECONFIG[input-wayland] = "-DUSE_INPUT_WAYLAND=ON,-DUSE_INPUT_WAYLAND=OFF,wayland"

FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/libWPEBackend-default.so ${libdir}/libWPEBackend-rdk.so"

RPROVIDES:${PN} += "virtual-wpebackend"

do_install() {
    install -d ${D}${libdir}
    install -m 0755 ${B}/libWPEBackend-*.so ${D}${libdir}/
}

# nooelint: oelint.vars.insaneskip - ignored for convenience. We need to recheck if problem persist
INSANE_SKIP = "dev-so"
