DESCRIPTION = "Helper binary for running applications sandboxed. Original: https://raw.githubusercontent.com/klihub/meta-flatpak"
HOMEPAGE = "https://github.com/projectatomic/bubblewrap"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2"

DEPENDS = "libcap"

SRC_URI = " \
    git://git@github.com/projectatomic/bubblewrap;protocol=https \
"
SRCREV = "3ebe54af1b2acb702381ec9b5610b60758d3d163"

PV = "2016.8+git${SRCPV}"
S = "${WORKDIR}/git"

inherit autotools pkgconfig systemd
AUTO_LIBNAME_PKGS = ""

# possible package configurations
PACKAGECONFIG ??= ""

EXTRA_OECONF_class-target += "--disable-man --without-bash-completion-dir"
EXTRA_OECONF_class-native += "--disable-man --without-bash-completion-dir"

BBCLASSEXTEND = "native"
