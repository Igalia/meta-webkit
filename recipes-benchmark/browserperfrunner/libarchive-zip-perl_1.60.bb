DESCRIPTION = "Archive::Zip - Provide an interface to ZIP archive files. \
               It provides also the crc32 binary"

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"
# License "Artistic-1.0 | GPL-1.0+" is also known as the "Perl" license.
LIC_FILES_CHKSUM = "file://META.yml;;beginline=13;endline=13;md5=963ce28228347875ace682de56eef8e8"

SRC_URI = "https://cpan.metacpan.org/authors/id/P/PH/PHRED/Archive-Zip-${PV}.tar.gz"

S = "${WORKDIR}/Archive-Zip-${PV}"

# crc32 at least depends on perl-module-lib, perl-module-cwd, perl-module-zip* ...
# so let's just depend on the perl-modules meta-package for simplicity.
RDEPENDS_${PN} += "perl-modules"

inherit cpan

SRC_URI[md5sum] = "ae7c617cdf909809b9b2210e620b03ca"
SRC_URI[sha256sum] = "eac75b05f308e860aa860c3094aa4e7915d3d31080e953e49bc9c38130f5c20b"
