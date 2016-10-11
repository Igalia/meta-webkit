require webkitgtk.inc

DEPENDS += " gnutls"

SRC_URI = "\
   https://www.webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
   file://Fix-GTK-build-with-USE_REDIRECTED_XCOMPO.patch \
"

SRC_URI[md5sum] = "20f21f48677559750581471c7aeb8648"
SRC_URI[sha256sum] = "0513ad836c624a3d24bdf1a99f4b4aead984ab6684150bc70f16db651590ea0a"
