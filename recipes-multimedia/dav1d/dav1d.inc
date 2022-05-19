SUMMARY = "dav1d is the fastest AV1 decoder on all platforms :)"
HOMEPAGE = "https://code.videolan.org/videolan/dav1d"
BUGTRACKER = "https://code.videolan.org/videolan/dav1d/-/issues"

SRC_URI = "https://code.videolan.org/videolan/${PN}/-/archive/${PV}/${PN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "097db6f370b88bf09fec62919c0d3af64e07d58210c665ec461d63f4ec79f6a2"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=c8055cfe7548dfdaa3a6dc45d8793669"

inherit meson
