require cog.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "aecf546d7b0645119d79559c5574cb5eb68364fc8409dfbd47a4920bd1f221bc"

PACKAGECONFIG[headless] = "-DCOG_PLATFORM_HEADLESS=ON,-DCOG_PLATFORM_HEADLESS=OFF,wpebackend-fdo"

SRC_URI_class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=cog-0.10"
SRCREV_class-devupstream = "cfbbde0331e11b5b9ab5b4cc0749d55cf74b3d05"

RDEPENDS_${PN} += "wpewebkit (>= 2.32)"
