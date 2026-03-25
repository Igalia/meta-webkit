# nooelint: oelint.vars.noncoreoverride - Ignore linter error on qemu-native bbappend because it is required to build qemu native in legacy system
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# nooelint: oelint.vars.noncoreoverride - Ignore linter error on qemu-native bbappend because it is required to build qemu native in legacy system
SRC_URI += "${@bb.utils.contains_any('LAYERSERIES_CORENAMES', 'scarthgap', '', 'file://0001-linux-user-Guard-RESOLVE_CACHED-flag-with-preprocess.patch', d)}"
