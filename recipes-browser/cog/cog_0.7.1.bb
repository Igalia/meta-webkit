require cog.inc

SRC_URI = "https://github.com/Igalia/cog/releases/download/v${PV}/cog-${PV}.tar.xz"

SRC_URI[sha256sum] = "42890e946652517abec8c0492d9fd8d827d5559652536a23a4c9ab8c1aecfe32"

BBCLASSEXTEND += "devupstream:target"

SRC_URI_class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=master"
SRCREV_class-devupstream = "f524ef214becc2f38299eae3d44313aef18c4e77"

RDEPENDS_${PN} += "wpewebkit (>= 2.24)"
