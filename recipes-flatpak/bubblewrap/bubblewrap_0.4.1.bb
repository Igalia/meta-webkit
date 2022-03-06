DESCRIPTION = "Helper binary for running applications sandboxed"
HOMEPAGE = "https://github.com/projectatomic/bubblewrap"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2"

DEPENDS = "libcap"

SRC_URI = "https://github.com/projectatomic/${BPN}/releases/download/v${PV}/${BP}.tar.xz"
SRC_URI[sha256sum] = "b9c69b9b1c61a608f34325c8e1a495229bacf6e4a07cbb0c80cf7a814d7ccc03"

inherit autotools pkgconfig systemd
AUTO_LIBNAME_PKGS = ""

# possible package configurations
PACKAGECONFIG ??= ""

EXTRA_OECONF:class-target += "--disable-man --without-bash-completion-dir"
EXTRA_OECONF:class-native += "--disable-man --without-bash-completion-dir"

BBCLASSEXTEND = "native"
