require cog.inc

SRC_URI[sha256sum] = "aecf546d7b0645119d79559c5574cb5eb68364fc8409dfbd47a4920bd1f221bc"

# Avalilable from 0.10.X
PACKAGECONFIG[headless] = "-DCOG_PLATFORM_HEADLESS=ON,-DCOG_PLATFORM_HEADLESS=OFF,wpebackend-fdo"

RDEPENDS_${PN} += "wpewebkit (>= 2.32)"
