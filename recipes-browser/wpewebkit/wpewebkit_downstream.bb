require wpewebkit.inc

HOMEPAGE = "https://github.com/WebPlatformForEmbedded"
BUGTRACKER = "https://github.com/WebPlatformForEmbedded/WPEWebKit/issues"
DEFAULT_PRERENCE = "-1"

# The downstream version of WPE is forked from the official one.
# This version includes some features that have not yet been considered
# (or accepted) for merging upstream, and also includes some extra quirks
# for specific embedded hardware.
#
# This version of WPE is not selected by default on this layer, as the
# upstream versions are preferred. To select it, add on your local.conf
# conf file the line below:
#
# PREFERRED_VERSION_wpewebkit = "1.downstream%"
#


# NOTE: The build of this recipe is currently broken after the versioning
#        changes done on wpebackend recipes. Remove this note and update
#        the commit below once that is fixed on the downstream repository.
PV = "1.downstream-20180424"
SRCREV = "a8f773758e16492d641456eb34a982029249fda4"
SRC_URI = "git://github.com/WebPlatformForEmbedded/WPEWebKit.git;protocol=https;branch=master"

DEPENDS += " wpebackend"

S = "${WORKDIR}/git"

# Some config options are only available on the downstream version, like:
PACKAGECONFIG[fusion] = "-DUSE_FUSION_API_GSTREAMER=ON,-DUSE_FUSION_API_GSTREAMER=OFF,"
PACKAGECONFIG[logs] ="-DENABLE_LOGS=ON,-DENABLE_LOGS=OFF,"
PACKAGECONFIG[nativevideo] = "-DENABLE_NATIVE_VIDEO=ON,-DENABLE_NATIVE_VIDEO=OFF,"
PACKAGECONFIG[subtitle] = "-DENABLE_TEXT_SINK=ON,-DENABLE_TEXT_SINK=OFF,"
PACKAGECONFIG[gst_httpsrc] = "-DUSE_GSTREAMER_WEBKIT_HTTP_SRC=ON,,"
PACKAGECONFIG[gst_holepunch] = "-DUSE_HOLE_PUNCH_GSTREAMER=ON,,"

# Hacks for some specific embedded hardware.
PACKAGECONFIG[intelce] = "-DUSE_WPEWEBKIT_PLATFORM_INTEL_CE=ON -DUSE_HOLE_PUNCH_GSTREAMER=ON,,"
PACKAGECONFIG[nexus] = "-DUSE_WPEWEBKIT_PLATFORM_BCM_NEXUS=ON -DUSE_HOLE_PUNCH_GSTREAMER=ON,,"
PACKAGECONFIG[qcomdb] = "-DUSE_WPEWEBKIT_PLATFORM_QCOM_DB=ON,,"
PACKAGECONFIG[egl] = "-DUSE_GSTREAMER_GL=ON,-DUSE_GSTREAMER_GL=OFF,virtual/egl"
PACKAGECONFIG[westeros] = "-DUSE_WPEWEBKIT_PLATFORM_WESTEROS=ON -DUSE_HOLE_PUNCH_GSTREAMER=ON -DUSE_WESTEROS_SINK=ON,,westeros"

# DRM stuff
PACKAGECONFIG[playready] = "-DENABLE_PLAYREADY=ON,-DENABLE_PLAYREADY=OFF,playready"
