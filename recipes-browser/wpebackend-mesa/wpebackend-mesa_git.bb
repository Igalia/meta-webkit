LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=6ae4db0d4b812334e1539cd5aa6e2f46"

DEPENDS = "wpebackend glib-2.0 libxkbcommon wayland virtual/libgl"
PROVIDES += "virtual/wpebackend"
RPROVIDES_${PN} += "virtual/wpebackend"

SRCREV = "3f9f87d5f42c27a22273d67db072bd7f2cba6135"
SRC_URI = "git://github.com/WebPlatformForEmbedded/WPEBackend-mesa.git;protocol=http;branch=master"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

PACKAGECONFIG ?= "gbm dma-buf"

PACKAGECONFIG[gbm] = "-DWPE_MESA_GBM=ON,-DWPE_MESA_GBM=OFF,"
PACKAGECONFIG[dma-buf] = "-DWPE_MESA_EXPORTABLE_DMA_BUF=ON,-DWPE_MESA_EXPORTABLE_DMA_BUF=OFF,"
PACKAGECONFIG[experimental-wayland] = "-DWPE_MESA_EXPERIMENTAL_WAYLAND_EGL=ON,-DWPE_MESA_EXPERIMENTAL_WAYLAND_EGL=OFF,"
PACKAGECONFIG[tegra] = "-DWPE_MESA_DRM_TEGRA_SUPPORT=ON,-DWPE_MESA_DRM_TEGRA_SUPPORT=OFF,"

do_install() {
	install -d ${D}${libdir}
	install -m 0755 ${B}/libWPEBackend-*.so ${D}${libdir}/
}

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/libWPEBackend-default.so ${libdir}/libWPEBackend-mesa.so"
INSANE_SKIP ="dev-so"
