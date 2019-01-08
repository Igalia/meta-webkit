meta-webkit (OpenEmbedded/Yocto layer for WebKit based engines and browsers)
============================================================================

This layer provides recipes of WebKit based runtimes and browsers for
use with OpenEmbedded and/or Yocto.

This layer depends on:

    URI: git://git.openembedded.org/openembedded-core
    branch: master
    revision: HEAD

    URI: git://git.openembedded.org/meta-openembedded
    branch: master
    revision: HEAD

    URI: http://code.qt.io/yocto/meta-qt5.git
    branch: 5.12
    revision: HEAD

The meta-qt5 dependency is necessary for the WPEWebKit engine. It provides an
opt-in Qt5 API as an alternative to other Qt5 web-engines such as QtWebKit and
QtWebEngine. As this is an optional component of WPEWebKit we believe that
adding meta-qt5 in your distro doesn't mean it needs to ship any Qt package
per-se.

For Yocto releases prior to thud we highly recommend users to add the meta-gstreamer1.0 layer to their distro:

    URI: https://github.com/OSSystems/meta-gstreamer1.0.git
    branch: rocko or sumo
    revision: HEAD


Building the WPE engine or WebKitGTK+
=====================================

Please refer to the project Wiki for a detailed guide:

   - WiKi: https://github.com/Igalia/meta-webkit/wiki
