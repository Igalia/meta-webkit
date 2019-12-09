
FILESEXTRAPATHS_prepend_beaglebone := "${THISDIR}/linux-ti-staging_4.19/:"

KERNEL_DEVICETREE_append_beaglebone = " \
    bbb-hdmi.dtb \
    bbb-nohdmi.dtb \
    bbb-4dcape43t.dtb \
    bbb-4dcape70t.dtb \
    bbb-nh5cape.dtb \
    bbb-nhd7cape.dtb \
"

SRC_URI_append_beaglebone = " \
    file://0001-spidev-Add-a-generic-compatible-id.patch \
    file://0002-dts-Revoke-Beaglebone-i2c2-cape-definitions.patch \
    file://0005-dts-Add-custom-dts-files.patch \
    file://0006-dts-Enable-sgx.patch \
    file://touchscreen.cfg \
    "
