require cog.inc
require conf/include/devupstream.inc

SRC_URI = "https://github.com/Igalia/cog/releases/download/${PV}/cog-${PV}.tar.xz"

SRC_URI[sha256sum] = "b82e917eb764943b9859c631974f8f0e748b79ae87bb7a944f46c818740e0208"

SRC_URI_class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=master"
SRCREV_class-devupstream = "fcffa7a82b960dd514a2fee5edcce660acce73e7"

RDEPENDS_${PN} += "wpewebkit (>= 2.28)"
