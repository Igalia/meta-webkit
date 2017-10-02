require webkitgtk.inc

SRC_URI = "\
   http://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
   file://fix-buildfailure-at-GLContextEGL.patch \
   file://gcc5.patch \
"

SRC_URI[md5sum] = "df79991848a5096d3a75289ebce547ae"
SRC_URI[sha256sum] = "3d1f0c534935f43fd74df90f2648fcee672d60f1f57a30fa557a77891ae04d20"

PACKAGECONFIG[libsecret] = "-DENABLE_CREDENTIAL_STORAGE=ON,-DENABLE_CREDENTIAL_STORAGE=OFF,libsecret"
