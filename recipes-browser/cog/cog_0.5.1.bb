require cog.inc

SRC_URI = "https://github.com/Igalia/cog/releases/download/v${PV}/cog-${PV}.tar.xz \
           file://0001-cog-launcher-Move-auto-ptr-declation-before-goto-sta.patch \
           "

SRC_URI[sha256sum] = "0160d942c7f2b832e4a7379f265e0e04e86a78b0e813340c36d029f98b74179e"

BBCLASSEXTEND += "devupstream:target"

SRC_URI_class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=master"
SRCREV_class-devupstream = "f524ef214becc2f38299eae3d44313aef18c4e77"

RDEPENDS_${PN} += "wpewebkit (>= 2.24)"
