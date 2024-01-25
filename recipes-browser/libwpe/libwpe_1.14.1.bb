require libwpe.inc
require libwpe-pkg.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "b1d0cdcf0f8dbb494e65b0f7913e357106da9a0d57f4fbb7b9d1238a6dbe9ade"

SRC_URI:class-devupstream = "git://github.com/WebPlatformForEmbedded/libwpe.git;protocol=https;branch=master"
SRCREV:class-devupstream = "d8b7324fbdf1e25a34a0ac601fcc2264ba0fa704"

