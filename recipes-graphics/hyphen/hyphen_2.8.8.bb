SUMMARY = "A text hyphenation library"
DESCRIPTION = "Hyphenation and justification library based on the TeX hyphenation algorithm."
HOMEPAGE = "http://hunspell.sourceforge.net/"
LICENSE = "LGPL-2.1-only | GPL-2.0-only | MPL-1.1"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=d45e3467790c1cae990cc9ca3293bc97 \
    file://COPYING.LGPL;md5=d8045f3b8f929c1cb29a1e3fd737b499 \
    file://COPYING.MPL;md5=bfe1f75d606912a4111c90743d6c7325 \
"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/hunspell/Hyphen/2.8/${BPN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "304636d4eccd81a14b6914d07b84c79ebb815288c76fe027b9ebff6ff24d5705"

inherit autotools pkgconfig

RDEPENDS:${PN} = "perl"

BBCLASSEXTEND = "native"
