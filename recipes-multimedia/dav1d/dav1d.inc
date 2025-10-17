SUMMARY = "dav1d is highest speed AV1 decoder for all platforms"
DESCRIPTION = "dav1d is an AV1 cross-platform decoder, open-source, \
               and focused on speed and correctness. \
               It is now battle-tested and production-ready and can \
               be used everywhere."
HOMEPAGE = "https://code.videolan.org/videolan/dav1d"
BUGTRACKER = "https://code.videolan.org/videolan/dav1d/-/issues"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=c8055cfe7548dfdaa3a6dc45d8793669"

inherit meson

DEPENDS:append = " nasm-native"

SRC_URI = " \
    https://code.videolan.org/videolan/${BPN}/-/archive/${PV}/${BPN}-${PV}.tar.gz \
    file://CVE-2024-1580.patch \
    "

SRC_URI[sha256sum] = "097db6f370b88bf09fec62919c0d3af64e07d58210c665ec461d63f4ec79f6a2"
