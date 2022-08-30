require libwpe.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "b84fdbfbc849ce4fdf084bb28b58e5463b1b4b6cc8f200dc77b41f8545d5329d"

SRC_URI:class-devupstream = "git://github.com/WebPlatformForEmbedded/libwpe.git;protocol=https;branch=master"
SRCREV:class-devupstream = "e2a90a50857f4095de7e763cc6adc8540275ff49"

