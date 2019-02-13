SUMMARY = "Qt5 WPE simple browser application"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=751419260aa954499f7abaabaa882bbe"


DEPENDS += "qtbase qtdeclarative qtquickcontrols2 wpewebkit"
RDEPENDS_${PN} += " wpewebkit-qtwpe-qml-plugin"

SRC_URI = "file://COPYING \
           file://CMakeLists.txt \
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
