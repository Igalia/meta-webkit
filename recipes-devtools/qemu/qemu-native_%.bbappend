FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "${@bb.utils.contains_any('LAYERSERIES_CORENAMES', 'kirkstone scarthgap', '', 'file://0001-linux-user-Guard-RESOLVE_CACHED-flag-with-preprocess.patch', d)}"
