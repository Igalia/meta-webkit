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

RDEPENDS_packagegroup-wpewebkit-depends = "\
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

RDEPENDS_packagegroup-wpewebkit-depends-sys-extended = "\
    curl \
    dhcp-client \
    hdparm \
    libaio \
    lzo \
    tmux \
    sysstat \
    unzip \
    watchdog \
    wget \
    which \
    zip \
    "

RDEPENDS_packagegroup-wpewebkit-depends-perl = "\
    gdbm \
    perl \
    perl-modules \
    perl-misc \
    perl-pod \
    perl-dev \
    zlib \
"

RDEPENDS_packagegroup-wpewebkit-depends-python = "\
    expat \
    gdbm \
    gmp \
    ncurses \
    openssl \
    python \
    python \
    python-modules \
    python-misc \
    readline \
    zip \
"

RDEPENDS_packagegroup-wpewebkit-depends-misc = "\
    chkconfig \
    gettext \
    gettext-runtime \
    groff \
    lsof \
    strace \
    libusb1 \
    usbutils \
    rpm \
    "

RDEPENDS_packagegroup-wpewebkit-depends-core = "\
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
    glibc-utils \
    elfutils \
    file \
    findutils \
    fontconfig-utils \
    gawk \
    grep \
    gzip \
    localedef \
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
    glibc \
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
    libsoup-2.4 \
    libwebp \
    libxml2 \
    libxslt \
    libepoxy \
    libgcrypt \
    bubblewrap \
    xdg-dbus-proxy \
    libseccomp \
    libicudata \
"

RDEPENDS_packagegroup-wpewebkit-depends-desktop = "\
    libxt \
    libxxf86vm \
    libdrm \
    libglu \
    libxi \
    libxtst \
    libx11-locale \
    xorg-minimal-fonts \
    gdk-pixbuf-loader-ico \
    gdk-pixbuf-loader-bmp \
    gdk-pixbuf-loader-ani \
    gdk-pixbuf-xlib \
    liberation-fonts \
    atk \
    at-spi2-atk \
    alsa-lib \
"

RDEPENDS_packagegroup-wpewebkit-depends-runtime-add = "\
    ldd \
    e2fsprogs-mke2fs \
    mkfontdir \
    liburi-perl \
    libxml-parser-perl \
    libxml-perl \
    libxml-sax-perl \
    glibc-localedatas \
    glibc-gconvs \
    glibc-charmaps \
    glibc-binaries \
    glibc-localedata-posix \
    glibc-extra-nss \
    glibc-pcprofile \
"

RDEPENDS_packagegroup-wpewebkit-depends-alternative = " \
    geoclue \
    libtasn1 \
    woff2 \
    libvpx \
    libevent \
    libopus \
    openjpeg \
"

RDEPENDS_packagegroup-wpewebkit-depends-video = " \
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
    gstreamer1.0-plugins-base-videoconvert \
    gstreamer1.0-plugins-base-videoscale \
    gstreamer1.0-plugins-base-volume \
    gstreamer1.0-plugins-base-typefindfunctions \
    gstreamer1.0-plugins-good-audiofx \
    gstreamer1.0-plugins-good-audioparsers \
    gstreamer1.0-plugins-good-autodetect \
    gstreamer1.0-plugins-good-avi \
    gstreamer1.0-plugins-good-deinterlace \
    gstreamer1.0-plugins-good-interleave \
    gstreamer1.0-plugins-bad-dashdemux \
    gstreamer1.0-plugins-bad-mpegtsdemux \
    gstreamer1.0-plugins-bad-smoothstreaming \
    gstreamer1.0-plugins-bad-videoparsersbad \
"

RDEPENDS_packagegroup-wpewebkit-depends-extra = " \
    ca-certificates \
    shared-mime-info \
    ttf-bitstream-vera \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta \
    gstreamer1.0-plugins-bad-meta \
"

RDEPENDS_packagegroup-wpewebkit-depends-tests = " \
    pkgconfig \
    p7zip \
    git \
    subversion \
    bzip2 \
    apache2 \
    apache2-scripts \
    curl \
    gdb \
    php \
    python \
    python-subprocess32 \
    python-pygobject \
    python-psutil \
    psmisc \
    pulseaudio \
    pulseaudio-misc \
    perl \
    perl-module-file-spec \
    perl-module-cgi \
    test-dicts \
    webkit-test-fonts \
    ruby \
    ruby-highline \
    ruby-json \
    brotli \
    libsoup-2.4 \
    cairo \
    fontconfig \
    freetype \
    harfbuzz \
    icu \
    woff2 \
    libwpe \
    wpebackend-fdo \
    libgpg-error \
    libgcrypt \
    libepoxy \
    wayland-protocols \
    openjpeg \
"
