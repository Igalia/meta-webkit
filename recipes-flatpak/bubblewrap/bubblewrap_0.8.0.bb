SUMMARY = "Helper binary for running applications sandboxed"
DESCRIPTION = "Bubblewrap is a low-level, unprivileged sandboxing utility that allows applications to be run in isolated environments. It creates a new mount namespace, giving fine-grained control over filesystem visibility. Bubblewrap can also leverage kernel features like user, IPC, PID, and network namespaces, as well as seccomp filters, to create robust sandboxes. It is a core component of container and sandboxing tools like Flatpak."
HOMEPAGE = "https://github.com/containers/bubblewrap"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2"

DEPENDS = "libcap"

SRC_URI = "https://github.com/containers/${BPN}/releases/download/v${PV}/${BP}.tar.xz"
SRC_URI[sha256sum] = "957ad1149db9033db88e988b12bcebe349a445e1efc8a9b59ad2939a113d333a"

inherit meson pkgconfig

PACKAGECONFIG ??= ""
PACKAGECONFIG[selinux] = "-Dselinux=enabled,-Dselinux=disabled,libselinux"

EXTRA_OEMESON += "-Dman=disabled -Dbash_completion=disabled -Dzsh_completion=disabled -Dtests=false"
