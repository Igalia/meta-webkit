SUMMARY = "A friendly, portable C implementation of the AV1 Image File Format"
DESCRIPTION = "This library aims to be a friendly, portable C implementation \
               of the AV1 Image File Format. \
               It can encode and decode all AV1 supported YUV formats and bit depths (with alpha). \
               In addition to the library, encoder and decoder command line tools are also \
               provided (avifenc and avifdec)."
HOMEPAGE = "https://github.com/AOMediaCodec/libavif"
BUGTRACKER = "https://github.com/AOMediaCodec/libavif/issues"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c528b75b07425b5c1d2e34de98c397b5"

SRC_URI = "git://github.com/AOMediaCodec/libavif.git;protocol=https;branch=main \
           file://CVE-2025-48174.patch \
           file://CVE-2025-48175.patch \
           "
SRCREV = "6ab53189045e7a6fe0bd93d14977b2a4f8efa5e9"

# nooelint: oelint.task.noanonpython - required for backward compatibility with scarthgap
python __anonymous() {
    if not d.getVar('UNPACKDIR'):
        d.setVar('S', d.getVar('WORKDIR') + '/git')
}

inherit cmake

PACKAGECONFIG ??= "dav1d"
PACKAGECONFIG[dav1d] = "-DAVIF_CODEC_DAV1D=ON,-DAVIF_CODEC_DAV1D=OFF,dav1d"
