require cog.inc

SRC_URI = "https://github.com/Igalia/cog/releases/download/v${PV}/cog-${PV}.tar.xz"

SRC_URI[md5sum] = "4a144065ee8f1f86b2aa686f3e1bf382"
SRC_URI[sha256sum] = "6f063c133ad65d153dad08f4f8d912539bfd8fe4ff174a8e3ff34dd80b34330f"

RDEPENDS_${PN} = "wpewebkit (>= 2.24)"
