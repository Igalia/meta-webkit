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

For Yocto releases prior to thud we highly recommend users to add the meta-gstreamer1.0 layer to their distro:

    URI: https://github.com/OSSystems/meta-gstreamer1.0.git
    branch: rocko or sumo
    revision: HEAD


Building the WPE engine or WebKitGTK+
=====================================

Please refer to the project Wiki for a detailed guide:

   - WiKi: https://github.com/Igalia/meta-webkit/wiki
