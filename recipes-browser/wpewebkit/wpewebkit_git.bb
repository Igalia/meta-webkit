require wpewebkit.inc

SRC_URI = " \
    git://github.com/WebKit/WebKit;protocol=https;branch=main \
    file://0001-Workaround-compiler-bug-for-inlining.patch \
"
SRCREV = "d287e1242bf08b3f98aa24d616a30a27c3e141b6"
S = "${WORKDIR}/git"