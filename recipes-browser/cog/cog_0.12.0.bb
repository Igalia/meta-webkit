COG_PACKAGECONFIG := " \
    ${@bb.utils.contains('PREFERRED_PROVIDER_virtual/wpebackend', 'wpebackend-fdo', 'wl', '', d)} \
"

require cog.inc
require conf/include/devupstream.inc


SRC_URI[sha256sum] = "aad413a8aaf15d400d70f9c909a28b92b138f7b0c0d825978de8788d0d75208a"

PACKAGECONFIG[headless] = "-DCOG_PLATFORM_HEADLESS=ON,-DCOG_PLATFORM_HEADLESS=OFF,wpebackend-fdo"
PACKAGECONFIG[wl] = "-DCOG_PLATFORM_WL=ON,-DCOG_PLATFORM_WL=OFF,wpebackend-fdo"

PACKAGECONFIG:class-devupstream ?= " ${@bb.utils.contains('PREFERRED_PROVIDER_virtual/wpebackend', 'wpebackend-fdo', 'fdo wl drm', '', d)} "

SRC_URI:class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=cog-0.12"
SRCREV:class-devupstream = "15902180647b66e63f005471c2f2d375f2cca831"

RDEPENDS:${PN} += "wpewebkit (>= 2.34)"
