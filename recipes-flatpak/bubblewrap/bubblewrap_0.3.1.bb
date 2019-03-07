DESCRIPTION = "Helper binary for running applications sandboxed"
HOMEPAGE = "https://github.com/projectatomic/bubblewrap"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2"

DEPENDS = "libcap"

SRC_URI = "https://github.com/projectatomic/${PN}/releases/download/v${PV}/${PN}-${PV}.tar.xz"
SRC_URI[md5sum] = "c34034985e80bdea39aaaaa4bcb92c64"
SRC_URI[sha256sum] = "deca6b608c54df4be0669b8bb6d254858924588e9f86e116eb04656a3b6d4bf8"

inherit autotools pkgconfig systemd
AUTO_LIBNAME_PKGS = ""

# possible package configurations
PACKAGECONFIG ??= ""

EXTRA_OECONF_class-target += "--disable-man --without-bash-completion-dir"
EXTRA_OECONF_class-native += "--disable-man --without-bash-completion-dir"

BBCLASSEXTEND = "native"
