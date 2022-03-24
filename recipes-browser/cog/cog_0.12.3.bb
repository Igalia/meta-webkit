require cog.inc
require conf/include/devupstream.inc


SRC_URI[sha256sum] = "f464065057373c0430f6267205d1ab3367b54ac04d15b6b5531683b03212f45f"

# Avalilable from 0.10.X
PACKAGECONFIG[headless] = "-DCOG_PLATFORM_HEADLESS=ON,-DCOG_PLATFORM_HEADLESS=OFF,wpebackend-fdo"

# Available from 0.12.X (future) or for devupstream (HEAD:master. Ref: https://github.com/Igalia/cog/commit/b595d12945148205af9da765cf05d092cbc234c4)
PACKAGECONFIG[wl] = "-DCOG_PLATFORM_WL=ON,-DCOG_PLATFORM_WL=OFF,wpebackend-fdo"

PACKAGECONFIG_class-devupstream ?= " ${@bb.utils.contains('PREFERRED_PROVIDER_virtual/wpebackend', 'wpebackend-fdo', 'fdo wl drm', '', d)} "

SRC_URI_class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=cog-0.12"
SRCREV_class-devupstream = "9f73faf7535358e4b296cbec63c9824fcacb634c"

RDEPENDS_${PN} += "wpewebkit (>= 2.34)"
