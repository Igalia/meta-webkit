require cog.inc
require conf/include/devupstream.inc

SRC_URI = "https://github.com/Igalia/cog/releases/download/v${PV}/cog-${PV}.tar.xz \
           file://0001-platform-add-a-common-EGL-proc-address-loader-with-d.patch \
           file://0002-egl-proc-address.h-add-a-license-header.patch \
           "

SRC_URI[sha256sum] = "181b1f4963cdf264b8068460a64d14c92a627f7138ebecc0f36fce085f4e92dd"

SRC_URI_class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=master"
SRCREV_class-devupstream = "fcffa7a82b960dd514a2fee5edcce660acce73e7"

RDEPENDS_${PN} += "wpewebkit (>= 2.28)"
