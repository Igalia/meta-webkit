require wpewebkit.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz \
    file://musl.patch \
    file://0001-ICU-69-deprecates-ubrk_safeClone-in-favor-of-ubrk_cl.patch \
    file://0001-Move-cloneUBreakIterator-declaration-to-IntlWorkarou.patch \
"

SRC_URI[sha256sum] = "6cfb18af9a180eeffffcaf34fea68d867ee59f633d811ced92bbead2d184b6ea"

DEPENDS += " libwpe"
RCONFLICTS_${PN} = "libwpe (< 1.4) wpebackend-fdo (< 1.6)"

PACKAGECONFIG_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd', '' ,d)}  unified-builds  service-worker"

PACKAGECONFIG[video] = "-DENABLE_VIDEO=ON,-DENABLE_VIDEO=OFF,gstreamer1.0 gstreamer1.0-plugins-base"
PACKAGECONFIG[unified-builds] = "-DENABLE_UNIFIED_BUILDS=ON,-DENABLE_UNIFIED_BUILDS=OFF,"
PACKAGECONFIG[systemd] = "-DUSE_SYSTEMD=ON,-DUSE_SYSTEMD=OFF,systemd"
PACKAGECONFIG[thunder] = "-DENABLE_THUNDER=ON,-DENABLE_THUNDER=OFF,virtual/open-cdm"
PACKAGECONFIG[video-plane-display-dmabuf] = "-DUSE_WPE_VIDEO_PLANE_DISPLAY_DMABUF=ON,-DUSE_WPE_VIDEO_PLANE_DISPLAY_DMABUF=OFF,wpebackend-fdo"
PACKAGECONFIG[webxr] = "-DENABLE_WEBXR=ON,-DENABLE_WEBXR=OFF,"
#TODO: Add recipe for openxr:
#  url: github_com:KhronosGroup/OpenXR-SDK.git
#  track: master
#  ref: release-1.0.11-0-ge3a4e41d61544d8e2eba73f00da99b6818ec472b

FILES_${PN}-qtwpe-qml-plugin = "${libdir}/qt5/qml/org/wpewebkit/qtwpe/*"

