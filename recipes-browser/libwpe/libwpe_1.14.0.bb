require libwpe.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "c073305bbac5f4402cc1c8a4753bfa3d63a408901f86182051eaa5a75dd89c00"

SRC_URI:class-devupstream = "git://github.com/WebPlatformForEmbedded/libwpe.git;protocol=https;branch=master"
SRCREV:class-devupstream = "d8b7324fbdf1e25a34a0ac601fcc2264ba0fa704"

