FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

python () {
    version = d.getVar('PV')
    if bb.utils.vercmp_string_op(version, "21.0.3", ">=") and \
            bb.utils.vercmp_string_op(version, "21.2.1", "<="):
                d.appendVar('SRC_URI', ' file://0001-gallium-dri-Make-YUV-formats-we-re-going-to-emulate-.patch')
}
