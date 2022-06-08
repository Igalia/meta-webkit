COG_PACKAGECONFIG := " \
    ${@bb.utils.contains('PREFERRED_PROVIDER_virtual/wpebackend', 'wpebackend-fdo', \
                         bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wl', '', d), \
                         '', d)}"

require cog.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "9983c621c8e14fca3792ff566cb6b86d6a1f17446eb4c083af4a5a749112982f"

PACKAGECONFIG[headless] = "-DCOG_PLATFORM_HEADLESS=ON,-DCOG_PLATFORM_HEADLESS=OFF,wpebackend-fdo"
PACKAGECONFIG[wl] = "-DCOG_PLATFORM_WL=ON,-DCOG_PLATFORM_WL=OFF,wpebackend-fdo"

SRC_URI:class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=cog-0.12"
SRCREV:class-devupstream = "9f73faf7535358e4b296cbec63c9824fcacb634c"

RDEPENDS:${PN} += "wpewebkit (>= 2.34)"
