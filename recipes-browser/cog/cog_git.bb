SUMMARY = "Cog is a small launcher designed for the WebKit WPE port. \
           But it also allows to use the WebKit GTK port instead. \
           Cog is small: provides no user interface, and is suitable \
           to be used as a Web application container. Cog may be \
           presented fullscreen depending on the WPE backend being used. \
           "
HOMEPAGE = "https://github.com/Igalia/cog"
BUGTRACKER = "https://github.com/Igalia/cog/issues"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=bf1229cd7425b302d60cdb641b0ce5fb"

# Please: keep PV to the date of the last update, so the version number
# is an always increasing number to avoid "version goes backwards" errors.
PV = "20180515"
SRCREV = "bab4ad47e9a579727779f2de084ebea36d6b8a1e"
SRC_URI = " git://github.com/Igalia/cog.git;protocol=https;branch=master \
            file://PR12.patch \
          "
S = "${WORKDIR}/git"

# Depend on wpewebkit unless the webkitgtk packageconfig option is selected.
DEPENDS = " \
            ${@bb.utils.contains('PACKAGECONFIG', 'webkitgtk', 'webkitgtk', 'wpewebkit', d)} \
            libsoup-2.4 glib-2.0 \
            "

# At run-time cog package should depend on virtual/wpebackend unless webkitgtk+ is enabled.
RDEPENDS_${PN} += "${@bb.utils.contains('PACKAGECONFIG', 'webkitgtk', '', 'virtual/wpebackend', d)}"
# If built with fdo support, it conflicts with dyz due to the libWPEBackend-default.so symlink
RCONFLICTS_${PN} += "${@bb.utils.contains('PACKAGECONFIG', 'fdo', 'dyz', '', d)}"

inherit cmake

# Cog can work with any wpebackend.
# But for using wpebackend-fdo this has to be enabled at build time.
PREFERRED_PROVIDER_virtual/wpebackend ?= "wpebackend-fdo"
PACKAGECONFIG ?= " ${@bb.utils.contains('PREFERRED_PROVIDER_virtual/wpebackend', 'wpebackend-fdo', 'fdo', '', d)} "

# libcogplatform*.so are plugins that should go on the main package (not on -dev)
# https://github.com/Igalia/cog/commit/758ed08555e8152a2becd2178d1f3a4ce6e67af9
# Also libWPEBackend-default.so should go into the main package.
FILES_SOLIBSDEV = "${libdir}/libcogcore*.so"
FILES_${PN} += "${libdir}/libcogplatform*.so ${libdir}/libWPEBackend-default.so"
INSANE_SKIP_${PN} = "dev-so"

# Use WebKitGTK+ instead of WPEWebKit
PACKAGECONFIG[webkitgtk] = "-DCOG_USE_WEBKITGTK=ON,-DCOG_USE_WEBKITGTK=OFF"
# Expose remote control interface on system bus.
PACKAGECONFIG[dbus] = "-DCOG_DBUS_SYSTEM_BUS=ON,-DCOG_DBUS_SYSTEM_BUS=OFF"
# Use wpebackend-fdo.
PACKAGECONFIG[fdo] = "-DCOG_PLATFORM_FDO=ON,-DCOG_PLATFORM_FDO=OFF,wpebackend-fdo"
