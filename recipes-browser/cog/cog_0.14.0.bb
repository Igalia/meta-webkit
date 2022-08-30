require cog.inc
require conf/include/devupstream.inc

SRC_URI[sha256sum] = "e23936f1ce350ea5ea6fa0709b63d34776b05709388aed9c6cf3fdc41299de9f"

SRC_URI:class-devupstream = "git://github.com/Igalia/cog.git;protocol=https;branch=cog-0.14"
SRCREV:class-devupstream = "343563b0866bc1802acbbdbb5f163bf9eba5c0ff"

RDEPENDS:${PN} += "wpewebkit (>= 2.36)"

