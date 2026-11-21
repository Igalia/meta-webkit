# FIXME: the LIC_FILES_CHKSUM values have been updated by 'devtool upgrade'.
# The following is the difference between the old and the new license text.
# Please update the LICENSE value if needed, and summarize the changes in
# the commit message via 'License-Update:' tag.
# (example: 'License-Update: copyright years updated.')
#
# The changes:
#
# --- META.yml
# +++ META.yml
# @@ -1 +1 @@
# -license: perl
# +meta-spec:
# 
#

SUMMARY = "Perl module for manipulating ZIP archive files"
DESCRIPTION = "Archive::Zip - Provide an interface to ZIP archive files. \
               It provides also the crc32 binary"
HOMEPAGE = "https://metacpan.org/pod/Archive::Zip"
SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0-or-later"
LIC_FILES_CHKSUM = "file://META.yml;beginline=13;endline=13;md5=b71b363ee61ae49d42efe496999a9db8"

SRC_URI = "https://cpan.metacpan.org/authors/id/P/PH/PHRED/Archive-Zip-${PV}.tar.gz;subdir=${BP};striplevel=1"

# crc32 at least depends on perl-module-lib, perl-module-cwd, perl-module-zip* ...
# so let's just depend on the perl-modules meta-package for simplicity.
RDEPENDS:${PN} += "perl-modules"

inherit cpan

SRC_URI[sha256sum] = "984e185d785baf6129c6e75f8eb44411745ac00bf6122fb1c8e822a3861ec650"

# cpan-base.bbclass builds the check regex out of the whole SRC_URI entry,
# parameters included, so subdir=${BP} makes it define the pver group twice
# and the regex no longer compiles. A failure here aborts the upgrade check
# for every recipe, not just this one.
UPSTREAM_CHECK_REGEX = "Archive-Zip-(?P<pver>\d+(\.\d+)+)\.tar\.gz"
