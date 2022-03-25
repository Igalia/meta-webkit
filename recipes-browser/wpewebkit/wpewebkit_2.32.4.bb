require wpewebkit.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "\
    https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
"

SRC_URI[tarball.sha256sum] = "381f1422cbc319db1aa42dda48de39590ed90ac3bec6b81ec83f3f2cae5c3eeb"

DEPENDS += " libwpe"
RCONFLICTS:${PN} = "libwpe (< 1.6) wpebackend-fdo (< 1.8)"

# Removed in 2.34
PACKAGECONFIG[indexeddb] = "-DENABLE_INDEXED_DATABASE=ON,-DENABLE_INDEXED_DATABASE=OFF,"

# Removed in 2.36
PACKAGECONFIG[gold] = "-DUSE_LD_GOLD=ON,-DUSE_LD_GOLD=OFF,"

PACKAGECONFIG:append = " indexeddb gold"

# Disable gold on mips/riscv. Mips/gold does not yet implement: error: .gnu.hash is incompatible with the MIPS ABI
PACKAGECONFIG:remove:riscv32 = "gold"
PACKAGECONFIG:remove:riscv64 = "gold"
PACKAGECONFIG:remove:mipsarcho32 = "gold"

