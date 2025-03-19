require wpewebkit.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
           file://0003-WPE-Platform-fix-wpe_toplevel_qtquick-has-not-been-d.patch \
           file://0004-WPE-Platform-fix-wpe_view_resize-was-not-declared-is.patch \
           file://0005-WPEPlatform-Input-methods-do-not-work.patch \
           "

SRC_URI[tarball.sha256sum] = "2f8f8447b9c7b0578f7d751ca27c682a2c180b5abb91542af52a96e8a24a6262"

# Experimental new WPE platform API
PACKAGECONFIG[experimental-wpe-platform] = "-DENABLE_WPE_PLATFORM=ON,-DENABLE_WPE_PLATFORM=OFF,libinput wayland-native"

EXTRA_OECMAKE += "-DUSE_SYSTEM_SYSPROF_CAPTURE=OFF"
