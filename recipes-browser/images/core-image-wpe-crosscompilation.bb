SUMMARY = "WPE cross-compilation image with wpebackend-fdo. \
           This is useful for creating a SDK for cross-building WPE. \
           The SDK for ARMv7 will default to use the traditional ISA. \
           To use Thumb2 you have to pass the -mthumb compiler flag."

LICENSE = "BSD"

inherit core-image

# distro_features_check is going to be removed after dunfell
# ref: https://git.yoctoproject.org/cgit/cgit.cgi/poky/commit/meta/classes/features_check.bbclass?h=master-next&id=9702544b3e75d761d86cae7e8b36f3f2625b68ce
#   Temporarily support the old class name with a warning about future deprecation.
inherit ${@bb.utils.contains_any("LAYERSERIES_CORENAMES", 'zeus warrior', 'distro_features_check', 'features_check', d)}

REQUIRED_DISTRO_FEATURES = "wayland"

PREFERRED_PROVIDER_virtual/wpebackend = "wpebackend-fdo"
CORE_IMAGE_BASE_INSTALL += "wpebackend-fdo wpewebkit"
