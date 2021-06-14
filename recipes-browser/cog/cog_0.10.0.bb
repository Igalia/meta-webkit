require cog.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "2c72369c636ca4684370adad1344071b23c9ee2c851eb7d738fa2e1d7092031f"
SRC_URI += "file://0001-platform-Add-COG_PLATFORM_HEADLESS-cmake-option.patch"

PACKAGECONFIG[headless] = "-DCOG_PLATFORM_HEADLESS=ON,-DCOG_PLATFORM_HEADLESS=OFF,wpebackend-fdo"
PACKAGECONFIG[soup2] = "-DUSE_SOUP2=ON,-DUSE_SOUP2=OFF,"

SRC_URI_class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=master"
SRCREV_class-devupstream = "10f0360cd1ef9f8258d7d4a06d4ab113f5635995"

RDEPENDS_${PN} += "wpewebkit (>= 2.32)"
