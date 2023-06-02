DESCRIPTION = "Convenience package which ships a symlink to point the python interpreter to python3"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/PSF-2.0;md5=76c1502273262a5ebefb50dfb20d7c4f"

inherit allarch

do_install() {
   install -d ${D}/${bindir}
   ln -sf python3 ${D}/${bindir}/python
}

FILES:${PN} = "${bindir}/python"
RDEPENDS:${PN} = "python3"
RCONFLICTS:${PN} = "python"

BBCLASSEXTEND = "native nativesdk"
