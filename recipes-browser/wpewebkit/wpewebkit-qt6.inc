inherit qt6-cmake

CMAKE_QT_OECONF = "\
    -DUSE_QT6=ON \
    -DENABLE_WPE_PLATFORM=ON \
"

QT_BUILD_DEPS =  "qtdeclarative-native wayland-native wayland-protocols wpebackend-fdo"

# Relocate the plugin to the default QML directory for accessibility.
do_install:append() {
    if [ -d ${D}${libdir}/qt6/qml/org/wpewebkit ]; then
        install -d ${D}${libdir}/qml/org/
        mv ${D}${libdir}/qt6/qml/org/wpewebkit ${D}${libdir}/qml/org/
        rm -rf ${D}${libdir}/qt6
    fi
}


FILES:${PN}-qtwpe-qml-plugin += "${libdir}/qml/org/wpewebkit/qtwpe/*"
