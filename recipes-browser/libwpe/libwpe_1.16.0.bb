require libwpe.inc
require ${@bb.utils.contains_any("LAYERSERIES_CORENAMES", 'dunfell', 'libwpe-pkg-dunfell.inc', 'libwpe-pkg.inc', d)}
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "c7f3a3c6b3d006790d486dc7cceda2b6d2e329de07f33bc47dfc53f00f334b2a"

SRC_URI:class-devupstream = "git://github.com/WebPlatformForEmbedded/libwpe.git;protocol=https;branch=master"
SRCREV:class-devupstream = "f57050fbff7c88ed68f5799128c71e249e2783bd"

