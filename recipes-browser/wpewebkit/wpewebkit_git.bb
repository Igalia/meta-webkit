require wpewebkit.inc

SRC_URI = " \
    git://github.com/WebKit/WebKit;protocol=https;branch=webkitglib/2.52 \
    file://0001-Workaround-compiler-bug-for-inlining.patch \
"
SRCREV = "d6e6276f013a421c9bfd645ac13bd7fa02068df5"
S = "${WORKDIR}/git"