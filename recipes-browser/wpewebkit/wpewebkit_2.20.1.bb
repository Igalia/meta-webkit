require wpewebkit.inc

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz \
           file://0001-REGRESSION-r217927-GTK-WPE-GSTREAMER_GL-Video-appear.patch \
          "
SRC_URI[md5sum] = "5e86ebd54bf49ff611f5623963362722"
SRC_URI[sha256sum] = "42dfcc1090cf37a817e23beb7402a753a69c891d7581ac69d733e39312d1e68a"
