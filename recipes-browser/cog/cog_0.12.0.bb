require cog.inc
require conf/include/devupstream.inc


SRC_URI[sha256sum] = "aad413a8aaf15d400d70f9c909a28b92b138f7b0c0d825978de8788d0d75208a"

# Avalilable from 0.10.X
PACKAGECONFIG[headless] = "-DCOG_PLATFORM_HEADLESS=ON,-DCOG_PLATFORM_HEADLESS=OFF,wpebackend-fdo"

# Available from 0.12.X (future) or for devupstream (HEAD:master. Ref: https://github.com/Igalia/cog/commit/b595d12945148205af9da765cf05d092cbc234c4)
PACKAGECONFIG[wl] = "-DCOG_PLATFORM_WL=ON,-DCOG_PLATFORM_WL=OFF,wpebackend-fdo"

PACKAGECONFIG:class-devupstream ?= " ${@bb.utils.contains('PREFERRED_PROVIDER_virtual/wpebackend', 'wpebackend-fdo', 'fdo wl drm', '', d)} "

SRC_URI:class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=cog-0.12"
SRCREV:class-devupstream = "15902180647b66e63f005471c2f2d375f2cca831"

RDEPENDS:${PN} += "wpewebkit (>= 2.34)"
