SUMMARY = "WPE cross-compilation image, using ARM Traditional ISA."

LICENSE = "BSD"

inherit core-image distro_features_check

REQUIRED_DISTRO_FEATURES = "wayland"

PREFERRED_PROVIDER_virtual/wpebackend = "wpebackend-fdo"
CORE_IMAGE_BASE_INSTALL += "wpebackend-fdo wpewebkit"
