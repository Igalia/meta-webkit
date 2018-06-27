SUMMARY = "WPE cross-compilation image with wpebackend-fdo. \
           This is useful for creating a SDK for cross-building WPE. \
           The SDK for ARMv7 will default to use the traditional ISA. \
           To use Thumb2 you have to pass the -mthumb compiler flag."

LICENSE = "BSD"

inherit core-image distro_features_check

REQUIRED_DISTRO_FEATURES = "wayland"

PREFERRED_PROVIDER_virtual/wpebackend = "wpebackend-fdo"
CORE_IMAGE_BASE_INSTALL += "wpebackend-fdo wpewebkit"
