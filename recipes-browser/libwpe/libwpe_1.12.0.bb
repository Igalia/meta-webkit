require libwpe.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "e8eeca228a6b4c36294cfb63f7d3ba9ada47a430904a5a973b3c99c96a44c18c"

SRC_URI:class-devupstream = "git://github.com/WebPlatformForEmbedded/libwpe.git;protocol=https;branch=master"
SRCREV:class-devupstream = "e2a90a50857f4095de7e763cc6adc8540275ff49"

