SUMMARY = "Small utility to print the EGL config / info on wayland"
DESCRIPTION = "A lightweight command-line utility designed to initialize a Wayland and EGL environment, query EGL configurations, and print detailed information about the available configs and EGL implementation. It is useful for debugging graphics driver issues and verifying EGL support on Wayland."

HOMEPAGE = "https://github.com/clopez/waylandeglinfo"
BUGTRACKER = "https://github.com/clopez/waylandeglinfo/issues"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=1c45a60ed9e3db41ec069e422044577e"
DEPENDS = "virtual/egl wayland"

SRC_URI = "git://github.com/clopez/waylandeglinfo.git;protocol=https;branch=master;destsuffix=${BP}"
SRCREV = "b295363ab4e858fe4cfb32ee4e71a177e939b691"

inherit cmake pkgconfig

