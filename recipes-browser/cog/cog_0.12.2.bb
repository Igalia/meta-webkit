COG_PACKAGECONFIG := " \
    ${@bb.utils.contains('PREFERRED_PROVIDER_virtual/wpebackend', 'wpebackend-fdo', 'wl', '', d)} \
"

require cog.inc
require conf/include/devupstream.inc


SRC_URI[sha256sum] = "ccebdc1f216b698d1e780d3a71617bec1d2cd95ac5c9da59f563372463d97ed7"

PACKAGECONFIG[headless] = "-DCOG_PLATFORM_HEADLESS=ON,-DCOG_PLATFORM_HEADLESS=OFF,wpebackend-fdo"
PACKAGECONFIG[wl] = "-DCOG_PLATFORM_WL=ON,-DCOG_PLATFORM_WL=OFF,wpebackend-fdo"

PACKAGECONFIG:class-devupstream ?= " ${@bb.utils.contains('PREFERRED_PROVIDER_virtual/wpebackend', 'wpebackend-fdo', 'fdo wl drm', '', d)} "

SRC_URI:class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=cog-0.12"
SRCREV:class-devupstream = "758c40e9e09940136d892866078477eb0467c709"

RDEPENDS:${PN} += "wpewebkit (>= 2.34)"
