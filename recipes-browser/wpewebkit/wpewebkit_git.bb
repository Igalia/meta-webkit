SUMMARY = "WPE WebKit port pairs the WebKit engine with the Wayland display protocol, \
           allowing embedders to create simple and performant systems based on Web platform technologies. \
           It is designed with hardware acceleration in mind, relying on EGL, the Wayland EGL platform, and OpenGL ES."
HOMEPAGE = "http://www.webkitforwayland.org/"
LICENSE = "BSD & LGPLv2+"
LIC_FILES_CHKSUM = "file://Source/WebCore/LICENSE-LGPL-2.1;md5=a778a33ef338abbaf8b8a7c36b6eec80 "

DEPENDS += " \
    wpebackend \
    bison-native gperf-native harfbuzz-native libxml2-native ruby-native ninja-native chrpath-replacement-native \
    cairo fontconfig freetype glib-2.0 gnutls harfbuzz icu jpeg pcre sqlite3 zlib \
    libpng libsoup-2.4 libwebp libxml2 libxslt \
    virtual/egl virtual/libgles2 \
"

PV = "1.20170828"
SRCREV = "aaab302388b1e75c8c085b184b1c0800557e3a6b"


SRC_URI = " git://github.com/WebPlatformForEmbedded/WPEWebKit.git;protocol=https;branch=master \
            file://0001-WebKitMacros-Append-to-I-and-not-to-isystem.patch \
            file://0001-WPE-Some-event-handlers-not-working.patch \
            file://0001-Better-support-for-video-playback-with-gstreamer-hol.patch \
          "

S = "${WORKDIR}/git"

inherit cmake pkgconfig perlnative pythonnative

TOOLCHAIN = "gcc"

PACKAGECONFIG ?= "deviceorientation fullscreenapi fetchapi gamepad geolocation indexeddb libinput logs mediasource notifications sampling-profiler shadowdom subtitle subtlecrypto udev video webaudio wayland touch"

# Mesa only offscreen target support for Westeros backend
# FIXME Needs to be moved to mesa backend
PACKAGECONFIG[westeros-mesa] = "-DUSE_WPEWEBKIT_BACKEND_WESTEROS_MESA=ON,,"

# WPE Platform specific switches
PACKAGECONFIG[intelce] = "-DUSE_WPEWEBKIT_PLATFORM_INTEL_CE=ON -DUSE_HOLE_PUNCH_GSTREAMER=ON,,"
PACKAGECONFIG[nexus] = "-DUSE_WPEWEBKIT_PLATFORM_BCM_NEXUS=ON -DUSE_HOLE_PUNCH_GSTREAMER=ON,,"
PACKAGECONFIG[westeros] = "-DUSE_WPEWEBKIT_PLATFORM_WESTEROS=ON -DUSE_HOLE_PUNCH_GSTREAMER=ON -DUSE_WESTEROS_SINK=ON,,westeros"

PACKAGECONFIG[wayland] = "-DUSE_WPEWEBKIT_BACKEND_WAYLAND_EGL=ON,,"

# WPE features
PACKAGECONFIG[2dcanvas] = "-DENABLE_ACCELERATED_2D_CANVAS=ON,-DENABLE_ACCELERATED_2D_CANVAS=OFF,"
PACKAGECONFIG[deviceorientation] = "-DENABLE_DEVICE_ORIENTATION=ON,-DENABLE_DEVICE_ORIENTATION=OFF,"
PACKAGECONFIG[encryptedmedia] = "-DENABLE_LEGACY_ENCRYPTED_MEDIA=ON,-DENABLE_LEGACY_ENCRYPTED_MEDIA=OFF,libgcrypt"
PACKAGECONFIG[encryptedmediav1] = "-DENABLE_LEGACY_ENCRYPTED_MEDIA_V1=ON,-DENABLE_LEGACY_ENCRYPTED_MEDIA_V1=OFF,libgcrypt"
PACKAGECONFIG[fetchapi] = "-DENABLE_FETCH_API=ON,-DENABLE_FETCH_API=OFF,"
PACKAGECONFIG[fullscreenapi] = "-DENABLE_FULLSCREEN_API=ON,-DENABLE_FULLSCREEN_API=OFF,"
PACKAGECONFIG[fusion] = "-DUSE_FUSION_API_GSTREAMER=ON,-DUSE_FUSION_API_GSTREAMER=OFF,"
PACKAGECONFIG[gamepad] = "-DENABLE_GAMEPAD=ON,-DENABLE_GAMEPAD=OFF,"
PACKAGECONFIG[geolocation] = "-DENABLE_GEOLOCATION=ON,-DENABLE_GEOLOCATION=OFF,"
PACKAGECONFIG[indexeddb] = "-DENABLE_DATABASE_PROCESS=ON -DENABLE_INDEXED_DATABASE=ON,-DENABLE_DATABASE_PROCESS=OFF -DENABLE_INDEXED_DATABASE=OFF,"
PACKAGECONFIG[libinput] = "-DUSE_WPEWEBKIT_INPUT_LIBINPUT=ON,-DUSE_WPEWEBKIT_INPUT_LIBINPUT=OFF,libinput"
PACKAGECONFIG[logs] = "-DLOG_DISABLED=OFF,-DLOG_DISABLED=ON,"
PACKAGECONFIG[mediasource] = "-DENABLE_MEDIA_SOURCE=ON,-DENABLE_MEDIA_SOURCE=OFF,gstreamer1.0 gstreamer1.0-plugins-good"
PACKAGECONFIG[mediastream] = "-DENABLE_MEDIA_STREAM=ON,-DENABLE_MEDIA_STREAM=OFF,openwebrtc"
PACKAGECONFIG[nativevideo] = "-DENABLE_NATIVE_VIDEO=ON,-DENABLE_NATIVE_VIDEO=OFF,"
PACKAGECONFIG[notifications] = "-DENABLE_NOTIFICATIONS=ON,-DENABLE_NOTIFICATIONS=OFF,"
PACKAGECONFIG[sampling-profiler] = "-DENABLE_SAMPLING_PROFILER=ON,-DENABLE_SAMPLING_PROFILER=OFF,"
PACKAGECONFIG[shadowdom] = "-DENABLE_SHADOW_DOM=ON,-DENABLE_SHADOW_DOM=OFF,"
PACKAGECONFIG[subtlecrypto] = "-DENABLE_SUBTLE_CRYPTO=ON,-DENABLE_SUBTLE_CRYPTO=OFF,"
PACKAGECONFIG[subtitle] = "-DENABLE_TEXT_SINK=ON,-DENABLE_TEXT_SINK=OFF,"
PACKAGECONFIG[touch] = "-DENABLE_TOUCH_EVENTS=ON,-DENABLE_TOUCH_EVENTS=OFF,"
PACKAGECONFIG[udev] = "-DUSE_WPEWEBKIT_INPUT_UDEV=ON,-DUSE_WPEWEBKIT_INPUT_UDEV=OFF,udev"
PACKAGECONFIG[video] = "-DENABLE_VIDEO=ON -DENABLE_VIDEO_TRACK=ON,-DENABLE_VIDEO=OFF -DENABLE_VIDEO_TRACK=OFF,gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad"
PACKAGECONFIG[webaudio] = "-DENABLE_WEB_AUDIO=ON,-DENABLE_WEB_AUDIO=OFF,gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good"

# DRM
PACKAGECONFIG[opencdm] = "-DENABLE_OCDM=ON,-DENABLE_OCDM=OFF,opencdm"
PACKAGECONFIG[playready] = "-DENABLE_PLAYREADY=ON,-DENABLE_PLAYREADY=OFF,playready"
PACKAGECONFIG[provisioning] = "-DENABLE_PROVISIONING=ON,-DENABLE_PROVISIONING=OFF,libprovision,libprovision"

# GStreamer
PACKAGECONFIG[gst_gl] = "-DUSE_GSTREAMER_GL=ON,,"
PACKAGECONFIG[gst_httpsrc] = "-DUSE_GSTREAMER_WEBKIT_HTTP_SRC=ON,,"
PACKAGECONFIG[gst_holepunch] = "-DUSE_HOLE_PUNCH_GSTREAMER=ON,,"
PACKAGECONFIG[gst_imx_holepunch] = "-DUSE_HOLE_PUNCH_GSTREAMER=ON -DUSE_IMX_SINK=ON,,"

EXTRA_OECMAKE += " \
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_COLOR_MAKEFILE=OFF -DBUILD_SHARED_LIBS=ON -DPORT=WPE \
    -G Ninja \
"
EXTRANATIVEPATH += "chrpath-native"

# don't build debug
FULL_OPTIMIZATION_remove = "-g"

# WPEWebProcess crashes when built with ARM mode on RPi
ARM_INSTRUCTION_SET_armv7a = "thumb"
ARM_INSTRUCTION_SET_armv7r = "thumb"
ARM_INSTRUCTION_SET_armv7m = "thumb"
ARM_INSTRUCTION_SET_armv7ve = "thumb"


do_compile() {
    ${STAGING_BINDIR_NATIVE}/ninja ${PARALLEL_MAKE} libWPEWebKit.so libWPEWebInspectorResources.so WPEWebProcess WPENetworkProcess WPEDatabaseProcess
}
do_compile[progress] = "outof:^\[(\d+)/(\d+)\]\s+"

do_install() {
    DESTDIR=${D} cmake -DCOMPONENT=Development -P ${B}/Source/WebKit2/cmake_install.cmake
    DESTDIR=${D} cmake -DCOMPONENT=Development -P ${B}/Source/JavaScriptCore/cmake_install.cmake

    install -d ${D}${libdir}
    cp -av --no-preserve=ownership ${B}/lib/libWPE* ${D}${libdir}/
    install -m 0755 ${B}/lib/libWPEWebInspectorResources.so ${D}${libdir}/
    # Hack: Remove the RPATH embedded in libWPEWebKit.so
    chrpath --delete ${D}${libdir}/libWPE*

    install -d ${D}${bindir}
    install -m755 ${B}/bin/WPEWebProcess ${D}${bindir}/
    install -m755 ${B}/bin/WPENetworkProcess ${D}${bindir}/
    install -m755 ${B}/bin/WPEDatabaseProcess ${D}${bindir}/

    # Hack: Remove RPATHs embedded in apps
    chrpath --delete ${D}${bindir}/WPEWebProcess
    chrpath --delete ${D}${bindir}/WPENetworkProcess
    chrpath --delete ${D}${bindir}/WPEDatabaseProcess
}

LEAD_SONAME = "libWPEWebKit.so"

PACKAGES =+ "${PN}-web-inspector-plugin"

FILES_${PN}-web-inspector-plugin += "${libdir}/libWPEWebInspectorResources.so"
INSANE_SKIP_${PN}-web-inspector-plugin = "dev-so"

PACKAGES =+ "${PN}-platform-plugin"


RDEPS_MEDIASOURCE = " \
    gstreamer1.0-plugins-good-isomp4 \
"

RDEPS_VIDEO = " \
    gstreamer1.0-plugins-base-app \
    gstreamer1.0-plugins-base-playback \
    gstreamer1.0-plugins-good-souphttpsrc \
"

RDEPS_WEBAUDIO = " \
    gstreamer1.0-plugins-good-wavparse \
"

# plugins-bad config option 'dash' -> gstreamer1.0-plugins-bad-dashdemux
# plugins-bad config option 'videoparsers' -> gstreamer1.0-plugins-bad-videoparsersbad

RDEPS_EXTRA = " \
    gstreamer1.0-plugins-base-audioconvert \
    gstreamer1.0-plugins-base-audioresample \
    gstreamer1.0-plugins-base-gio \
    gstreamer1.0-plugins-base-videoconvert \
    gstreamer1.0-plugins-base-videoscale \
    gstreamer1.0-plugins-base-volume \
    gstreamer1.0-plugins-base-typefindfunctions \
    gstreamer1.0-plugins-good-audiofx \
    gstreamer1.0-plugins-good-audioparsers \
    gstreamer1.0-plugins-good-autodetect \
    gstreamer1.0-plugins-good-avi \
    gstreamer1.0-plugins-good-deinterlace \
    gstreamer1.0-plugins-good-interleave \
    gstreamer1.0-plugins-bad-dashdemux \
    gstreamer1.0-plugins-bad-mpegtsdemux \
    gstreamer1.0-plugins-bad-smoothstreaming \
    gstreamer1.0-plugins-bad-videoparsersbad \
"

RDEPS_VIDEOGL = " \
    gstreamer1.0-omx \
    gstreamer1.0-plugins-bad-opengl \
"
#fixme
#    gstreamer1.0-plugins-bad-faad (videogl=> aac)
#    gstreamer1.0-plugins-bad-hls
#    gstreamer1.0-plugins-ugly-mpg123


RDEPS_MEDIASOURCE += "${RDEPS_EXTRA}"
RDEPS_VIDEO += "${RDEPS_EXTRA}"
RDEPS_WEBAUDIO += "${RDEPS_EXTRA}"

RRECOMMENDS_${PN} += " \
    ca-certificates \
    shared-mime-info \
    ttf-bitstream-vera \
    ${PN}-platform-plugin \
"
# FIXME: add this conditionally based on selected pkconfig entries
RDEPENDS_${PN} = " ${RDEPS_MEDIASOURCE} ${RDEPS_VIDEO} ${RDEPS_VIDEOGL} ${RDEPS_WEBAUDIO} ${RDEPS_EXTRA} "
