COG_PACKAGECONFIG := " \
    ${@bb.utils.contains('PREFERRED_PROVIDER_virtual/wpebackend', 'wpebackend-fdo', 'fdo', '', d)} \
"

require cog.inc

PACKAGECONFIG[fdo] = "-DCOG_PLATFORM_FDO=ON,-DCOG_PLATFORM_FDO=OFF,wpebackend-fdo"
PACKAGECONFIG[webkitgtk] = "-DCOG_USE_WEBKITGTK=ON,-DCOG_USE_WEBKITGTK=OFF"

SRC_URI[sha256sum] = "b82e917eb764943b9859c631974f8f0e748b79ae87bb7a944f46c818740e0208"

RDEPENDS:${PN} += "wpewebkit (>= 2.28)"
