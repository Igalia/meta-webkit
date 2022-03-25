require wpewebkit.inc
require conf/include/devupstream.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
"

SRC_URI[tarball.sha256sum] = "301e895c8ed08ce7dccef3192b972f2ccfc2020463244c64069a636f2b05265f"

DEPENDS += " libwpe"
RCONFLICTS:${PN} = "libwpe (< 1.8) wpebackend-fdo (< 1.10)"

SRC_URI:class-devupstream = "\
    git://git.webkit.org/WebKit.git;branch=master \
    file://0002-libyuv-gcc-issue.patch \
"
# WPE 2.34.X branch was forked from the main branch in this commit
SRCREV:class-devupstream = "30c41fe654d9556a5681663166c1461132326ff7"

# Needed for since >2.34.
PACKAGECONFIG[dfg-jit] = "-DENABLE_DFG_JIT=ON,-DENABLE_DFG_JIT=OFF,"
PACKAGECONFIG[jit] = "-DENABLE_JIT=ON,-DENABLE_JIT=OFF,"
PACKAGECONFIG[lcms] = "-DUSE_LCMS=ON,-DUSE_LCMS=OFF,"

# Removed in 2.36
PACKAGECONFIG[gold] = "-DUSE_LD_GOLD=ON,-DUSE_LD_GOLD=OFF,"

PACKAGECONFIG:append = " gold dfg-jit"

# Disable gold on mips/riscv. Mips/gold does not yet implement: error: .gnu.hash is incompatible with the MIPS ABI
PACKAGECONFIG:remove:riscv32 = "gold"
PACKAGECONFIG:remove:riscv64 = "gold"
PACKAGECONFIG:remove:mipsarcho32 = "gold"

# libsoup-3 will be available not before Poky kirkstone.
# http://git.yoctoproject.org/cgit/cgit.cgi/poky/commit/meta/recipes-support/libsoup/libsoup_3.0.1.bb?id=de296e2b2be876ca5cf2af309b710111e2b2581e
EXTRA_OECMAKE += "-DUSE_SOUP2=ON"

