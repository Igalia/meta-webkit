SUMMARY = "Qt5 WPE simple browser application"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/LGPL-2.1;md5=1a6d268fd218675ffea8be556788b780"

DEPENDS += "qtbase qtdeclarative qtquickcontrols2 wpewebkit"
RDEPENDS_${PN} += " wpewebkit-qtwpe-qml-plugin"

SRC_URI = "file://CMakeLists.txt \
           file://main.cpp \
           file://main.qml \
           file://qml.qrc \
"

S = "${WORKDIR}"

inherit cmake cmake_qt5

do_install() {
      install -d ${D}${bindir}/
      install -m 0755 qt-wpe-simple-browser ${D}${bindir}
}
