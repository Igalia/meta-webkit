# nooelint: oelint.vars.noncoreoverride - Ignore linter error on qemu-native bbappend because it is required to build qemu native in legacy system
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# nooelint: oelint.vars.noncoreoverride - Ignore linter error for patch in qemu-native bbappend because. It is required to build qemu native in legacy system
SRC_URI += "file://0001-linux-user-Guard-RESOLVE_CACHED-flag-with-preprocess.patch"
