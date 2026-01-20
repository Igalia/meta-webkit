SUMMARY = "Package groups for runtime dependencies"
DESCRIPTION = "Package groups used for runtime dependencies"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PACKAGES = " \
    packagegroup-wpewebkit-depends \
    packagegroup-wpewebkit-depends-sys-extended \
    packagegroup-wpewebkit-depends-perl \
    packagegroup-wpewebkit-depends-python \
    packagegroup-wpewebkit-depends-misc \
    packagegroup-wpewebkit-depends-core \
    packagegroup-wpewebkit-depends-desktop \
    packagegroup-wpewebkit-depends-runtime-add \
    packagegroup-wpewebkit-depends-alternative \
    packagegroup-wpewebkit-depends-video \
    packagegroup-wpewebkit-depends-extra \
    packagegroup-wpewebkit-depends-tests \
"

RDEPENDS:packagegroup-wpewebkit-depends = "\
    packagegroup-wpewebkit-depends-alternative \
    packagegroup-wpewebkit-depends-core \
    packagegroup-wpewebkit-depends-desktop \
    packagegroup-wpewebkit-depends-extra \
    packagegroup-wpewebkit-depends-misc \
    packagegroup-wpewebkit-depends-perl \
    packagegroup-wpewebkit-depends-python \
    packagegroup-wpewebkit-depends-runtime-add \
    packagegroup-wpewebkit-depends-sys-extended \
    packagegroup-wpewebkit-depends-tests \
    packagegroup-wpewebkit-depends-video \
"

RDEPENDS:packagegroup-wpewebkit-depends-sys-extended = "\
    curl \
    dhcpcd \
    hdparm \
    libaio \
    lzo \
    sysstat \
    tmux \
    unzip \
    watchdog \
    wget \
    which \
    zip \
    "

RDEPENDS:packagegroup-wpewebkit-depends-perl = "\
    gdbm \
    perl \
    perl-dev \
    perl-misc \
    perl-modules \
    perl-pod \
    zlib \
"

RDEPENDS:packagegroup-wpewebkit-depends-python = "\
    expat \
    gdbm \
    gmp \
    ncurses \
    openssl \
    python-is-python3 \
    readline \
    zip \
"

STRACE = "strace"
STRACE:riscv32 = ""

# nooelint: oelint.vars.dependsordered - ignored for convenience
RDEPENDS:packagegroup-wpewebkit-depends-misc = "\
    gettext \
    gettext-runtime \
    groff \
    libusb1 \
    lsof \
    ${STRACE} \
    rpm \
    usbutils \
"

# nooelint: oelint.vars.dependsordered - ignored for convenience
RDEPENDS:packagegroup-wpewebkit-depends-core = "\
    at \
    bash \
    bc \
    binutils \
    binutils-symlinks \
    bzip2 \
    coreutils \
    cpio \
    cronie \
    diffutils \
    ed \
    elfutils \
    file \
    findutils \
    fontconfig-utils \
    gawk \
    grep \
    gzip \
    make \
    msmtp \
    patch \
    procps \
    psmisc \
    sed \
    shadow \
    tar \
    time \
    util-linux \
    xdg-utils \
    libgcc \
    libpam \
    libxml2 \
    ncurses \
    zlib \
    nspr \
    nss \
    bison \
    gperf \
    libxml2 \
    ruby \
    cairo \
    fontconfig \
    freetype \
    glib-2.0 \
    gnutls \
    harfbuzz \
    harfbuzz-icu \
    icu \
    jpeg \
    sqlite3 \
    zlib \
    libpng \
    libsoup \
    libwebp \
    libxml2 \
    libxslt \
    libepoxy \
    libgcrypt \
    bubblewrap \
    xdg-dbus-proxy \
    ${@bb.utils.contains('BBFILE_COLLECTIONS', 'security', 'libseccomp', '', d)} \
    libicudata \
    libwpe \
    ${PREFERRED_PROVIDER_virtual/wpebackend} \
    libgpg-error \
    libgcrypt \
    libepoxy \
    wayland-protocols \
    openjpeg \
    libbacktrace \
    hyphen \
"

RDEPENDS:packagegroup-wpewebkit-depends-core:append:libc-glibc = " \
    glibc \
    glibc-utils \
    localedef \
"

# nooelint: oelint.vars.dependsordered - ignored for convenience
RDEPENDS:packagegroup-wpewebkit-depends-desktop = "\
    alsa-lib \
    atk \
    at-spi2-atk \
    gdk-pixbuf \
    libdrm \
    liberation-fonts \
    libglu \
    libportal \
    libx11-locale \
    libxi \
    libxkbcommon \
    libxt \
    libxtst \
    libxxf86vm \
    xcb-util-cursor \
    xorg-minimal-fonts \
"

# nooelint: oelint.vars.dependsordered - ignored for convenience
RDEPENDS:packagegroup-wpewebkit-depends-runtime-add = "\
    ldd \
    e2fsprogs-mke2fs \
    mkfontdir \
    liburi-perl \
    libxml-parser-perl \
    libxml-perl \
    libxml-sax-perl \
"

# nooelint: oelint.vars.dependsordered - ignored for convenience
RDEPENDS:packagegroup-wpewebkit-depends-runtime-add:append:libc-glibc = " \
    glibc-localedatas \
    glibc-gconvs \
    glibc-charmaps \
    glibc-binaries \
    glibc-localedata-posix \
    glibc-extra-nss \
    glibc-pcprofile \
"

# nooelint: oelint.vars.dependsordered - ignored for convenience
RDEPENDS:packagegroup-wpewebkit-depends-alternative = " \
    flite \
    geoclue \
    libavif \
    libevent \
    libjxl \
    libopus \
    libtasn1 \
    libvpx \
    ${@bb.utils.contains('LICENSE_FLAGS_ACCEPTED', 'commercial', 'openh264', '', d)} \
    openjpeg \
    openxr \
    sparkle-cdm \
    woff2 \
"

# nooelint: oelint.vars.dependsordered - ignored for convenience
RDEPENDS:packagegroup-wpewebkit-depends-video = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-good-isomp4 \
    gstreamer1.0-plugins-good-wavparse \
    gstreamer1.0-plugins-base-opengl \
    gstreamer1.0-plugins-base-app \
    gstreamer1.0-plugins-base-playback \
    gstreamer1.0-plugins-good-souphttpsrc \
    gstreamer1.0-plugins-base-audioconvert \
    gstreamer1.0-plugins-base-audioresample \
    gstreamer1.0-plugins-base-gio \
    gstreamer1.0-plugins-base-videoconvertscale \
    gstreamer1.0-plugins-base-volume \
    gstreamer1.0-plugins-base-typefindfunctions \
    gstreamer1.0-plugins-good-audiofx \
    gstreamer1.0-plugins-good-audioparsers \
    gstreamer1.0-plugins-good-autodetect \
    gstreamer1.0-plugins-good-avi \
    gstreamer1.0-plugins-good-deinterlace \
    gstreamer1.0-plugins-good-interleave \
    gstreamer1.0-plugins-bad-mpegtsdemux \
    gstreamer1.0-plugins-bad-smoothstreaming \
    gstreamer1.0-plugins-bad-videoparsersbad \
    ${@bb.utils.contains('LICENSE_FLAGS_ACCEPTED', 'commercial', 'gstreamer1.0-libav', '', d)} \
"

RDEPENDS:packagegroup-wpewebkit-depends-extra = " \
    ca-certificates \
    gstreamer1.0-plugins-bad-meta \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta \
    shared-mime-info \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    ttf-dejavu-serif \
"

# nooelint: oelint.vars.dependsordered - ignored for convenience
RDEPENDS:packagegroup-wpewebkit-depends-tests = " \
    pkgconfig \
    p7zip \
    git \
    subversion \
    bzip2 \
    curl \
    gdb \
    php \
    psmisc \
    pulseaudio \
    pulseaudio-misc \
    perl \
    perl-module-file-spec \
    libcgi-perl \
    libarchive-zip-perl \
    test-dicts \
    webkit-test-fonts \
    ruby \
    ruby-highline \
    ruby-json \
    python3-dev \
    python3-pip \
    python3-psutil \
    python3-pygobject \
    python3-twisted \
    libc6-dev \
    gcc \
    g++ \
    gcc-dev \
"
