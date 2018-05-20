require wpewebkit.inc

SRC_URI = "https://wpewebkit.org/releases/${PN}-${PV}.tar.xz \
           file://0001-REGRESSION-r217927-GTK-WPE-GSTREAMER_GL-Video-appear.patch \
           file://0001-Revert-Merged-r231843-CMake-Properly-detect-compiler.patch \
          "
SRC_URI[md5sum] = "ba228301dc22ebfb86035f36dc5fb529"
SRC_URI[sha256sum] = "5a3b0428e18fce25c1b93832bcba8cad705b5dab3a0cd9cb0aacba9d7893f1a0"
