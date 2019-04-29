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

    URI: git://git.yoctoproject.org/meta-security
    branch: master
    revision: HEAD

This layer optionally depends on:

    URI: http://code.qt.io/yocto/meta-qt5.git
    branch: 5.12
    revision: HEAD

The meta-security dependency is necessary to enable web process sandbox for WPE.

If meta-qt5 is present, this layer will provide an opt-in Qt5 API as an
alternative to other Qt5 web-engines such as QtWebKit and QtWebEngine.

For Yocto releases prior to thud we highly recommend users to add the meta-gstreamer1.0 layer to their distro:

    URI: https://github.com/OSSystems/meta-gstreamer1.0.git
    branch: rocko or sumo
    revision: HEAD


Building the WPE engine or WebKitGTK+
=====================================

Please refer to the project Wiki for a detailed guide:

   - WiKi: https://github.com/Igalia/meta-webkit/wiki
