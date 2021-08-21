SUMMARY = "A minimal seat management daemon"
HOMEPAGE = "https://git.sr.ht/~kennylevinsen/seatd"
BUGTRACKER = "https://git.sr.ht/~kennylevinsen/seatd"

SRC_URI = "https://git.sr.ht/~kennylevinsen/${PN}/archive/${PV}.tar.gz"
SRC_URI[sha256sum] = "274b56324fc81ca6002bc1cdd387668dee34a6e1063e5f3896805c3770948988"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=715a99d2dd552e6188e74d4ed2914d5a"

inherit meson pkgconfig
