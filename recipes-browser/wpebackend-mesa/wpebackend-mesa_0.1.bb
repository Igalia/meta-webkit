LICENSE = "CLOSED"

DEPENDS = "wpebackend glib-2.0 libxkbcommon wayland mesa-gl"

SRCREV = "de843e2536f3a445737ce39ab643516a23531d5e"

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
