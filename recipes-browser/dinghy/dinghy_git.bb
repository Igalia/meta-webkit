SUMMARY = "Dinghy is a small launcher designed for the WebKit WPE port. \
           But it also allows to use the WebKit GTK port instead. \
           Dinghy is small: provides no user interface, and is suitable \
           to be used as a Web application container. Dinghy may be \
           presented fullscreen depending on the WPE backend being used. \
           "
HOMEPAGE = "https://github.com/Igalia/dinghy"
BUGTRACKER = "https://github.com/Igalia/dinghy/issues"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=bf1229cd7425b302d60cdb641b0ce5fb"

PV= "20180416"
SRCREV = "5ec83eccc59c9d54c2edacf63129c1497d2323e4"
SRC_URI = "git://github.com/Igalia/dinghy.git;protocol=https;branch=master"
S = "${WORKDIR}/git"

# Depend on wpewebkit unless the webkitgtk packageconfig option is selected.
DEPENDS = " \
            ${@bb.utils.contains('PACKAGECONFIG', 'webkitgtk', 'webkitgtk', 'wpewebkit', d)} \
            libsoup-2.4 glib-2.0 \
            "

inherit cmake

# Use WebKitGTK+ instead of WPEWebKit
PACKAGECONFIG[webkitgtk] = "-DDY_USE_WEBKITGTK=ON,-DDY_USE_WEBKITGTK=OFF"
# Expose remote control interface on system bus.
PACKAGECONFIG[dbus] = "-DDY_DBUS_SYSTEM_BUS=ON,-DDY_DBUS_SYSTEM_BUS=OFF"
# Use the SysFS graphics mode monitor to detect resolution changes.
PACKAGECONFIG[monitor] = "-DDY_USE_MODE_MONITOR=ON,-DDY_USE_MODE_MONITOR=OFF,udev libdrm"
