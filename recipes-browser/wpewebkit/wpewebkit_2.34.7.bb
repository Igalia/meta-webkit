require wpewebkit.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
"

SRC_URI[tarball.sha256sum] = "092659bf43e5bc6f2a5a7b8e612a39da5da56a04f41eacc716638f53a27c3412"

DEPENDS += " libwpe"
RCONFLICTS:${PN} = "libwpe (< 1.8) wpebackend-fdo (< 1.10)"

# Needed for since >2.34.
PACKAGECONFIG[dfg-jit] = "-DENABLE_DFG_JIT=ON,-DENABLE_DFG_JIT=OFF,"
PACKAGECONFIG[jit] = "-DENABLE_JIT=ON,-DENABLE_JIT=OFF,"
PACKAGECONFIG[lcms] = "-DUSE_LCMS=ON,-DUSE_LCMS=OFF,"

# Removed in 2.36
PACKAGECONFIG[gold] = "-DUSE_LD_GOLD=ON,-DUSE_LD_GOLD=OFF,"
# Replaced by ENABLE_JOURNALD_LOG in the future 2.36.X
PACKAGECONFIG[systemd] = "-DUSE_SYSTEMD=ON,-DUSE_SYSTEMD=OFF,systemd"

PACKAGECONFIG:append = " gold dfg-jit ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd', '' ,d)}"

# Disable gold on mips/riscv. Mips/gold does not yet implement: error: .gnu.hash is incompatible with the MIPS ABI
PACKAGECONFIG:remove:riscv32 = "gold"
PACKAGECONFIG:remove:riscv64 = "gold"
PACKAGECONFIG:remove:mipsarcho32 = "gold"

# libsoup-3 will be available not before Poky kirkstone.
# http://git.yoctoproject.org/cgit/cgit.cgi/poky/commit/meta/recipes-support/libsoup/libsoup_3.0.1.bb?id=de296e2b2be876ca5cf2af309b710111e2b2581e
EXTRA_OECMAKE += "-DUSE_SOUP2=ON"

