COG_PACKAGECONFIG := " \
    ${@bb.utils.contains('PREFERRED_PROVIDER_virtual/wpebackend', 'wpebackend-fdo', 'fdo', '', d)} \
"

require cog.inc

SRC_URI[sha256sum] = "aecf546d7b0645119d79559c5574cb5eb68364fc8409dfbd47a4920bd1f221bc"

PACKAGECONFIG[fdo] = "-DCOG_PLATFORM_FDO=ON,-DCOG_PLATFORM_FDO=OFF,wpebackend-fdo"
PACKAGECONFIG[headless] = "-DCOG_PLATFORM_HEADLESS=ON,-DCOG_PLATFORM_HEADLESS=OFF,wpebackend-fdo"

RDEPENDS:${PN} += "wpewebkit (>= 2.32)"
