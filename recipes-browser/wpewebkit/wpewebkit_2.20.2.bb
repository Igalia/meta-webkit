require wpewebkit.inc

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz \
           file://0001-REGRESSION-r217927-GTK-WPE-GSTREAMER_GL-Video-appear.patch \
          "
SRC_URI[md5sum] = "07cb30291a8311f3cf126e3a2e3d0efb"
SRC_URI[sha256sum] = "0950befe6e970c9219ccbc29f5ff08bcc0923f0a9ca5a4c7531d74f9e26617f2"

DEPENDS += " wpebackend"

RCONFLICTS_${PN} = "libwpe (>= 1.0) wpebackend-fdo (>= 1.0)"