require cog.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "aecf546d7b0645119d79559c5574cb5eb68364fc8409dfbd47a4920bd1f221bc"

# Avalilable from 0.10.X
PACKAGECONFIG[headless] = "-DCOG_PLATFORM_HEADLESS=ON,-DCOG_PLATFORM_HEADLESS=OFF,wpebackend-fdo"

# Available from 0.12.X (future) or for devupstream (HEAD:master. Ref: https://github.com/Igalia/cog/commit/b595d12945148205af9da765cf05d092cbc234c4)
PACKAGECONFIG[wl] = "-DCOG_PLATFORM_WL=ON,-DCOG_PLATFORM_WL=OFF,wpebackend-fdo"

PACKAGECONFIG_class-devupstream ?= " ${@bb.utils.contains('PREFERRED_PROVIDER_virtual/wpebackend', 'wpebackend-fdo', 'fdo wl drm', '', d)} "

SRC_URI_class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=cog-0.10"
SRCREV_class-devupstream = "cfbbde0331e11b5b9ab5b4cc0749d55cf74b3d05"

RDEPENDS_${PN} += "wpewebkit (>= 2.32)"
