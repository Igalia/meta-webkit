require wpebackend-fdo.inc

inherit cmake

SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "740eee3327acfb462b8460519a219e30dc0a870326e88e2ddc4fe2c8de20b1c9"

