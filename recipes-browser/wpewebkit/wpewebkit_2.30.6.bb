require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
    file://216455_builds_with_ENABLE_SERVICE_WORKER_OFF.patch;name=216455 \
    file://274943-GStreamer-Use-imxvideoconvert_g2d-element-inside-the.patch;name=274943 \
"

SRC_URI[tarball.sha256sum] = "893a3098226f116bbb38a665a3053c7d30e3c5dca786b954f9aa38f8c8581468"
SRC_URI[216455.sha256sum] = "ddbc5ad149d1448025f0a4437ad45bcb4d21b44ca6b7e4267751f431ff882c3e"
SRC_URI[274943.sha256sum] = "efd5722f95a74503983aba0f844765a9bffa0ee4779dfc65000bf099122bca0c"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.4) wpebackend-fdo (< 1.6)"

