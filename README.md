meta-webkit (OpenEmbedded/Yocto layer for WebKit based engines and browsers)
============================================================================

This layer provides recipes of WebKit based runtimes and browsers for
use with OpenEmbedded and/or Yocto.

This layer depends on:

    URI: git://git.openembedded.org/openembedded-core
    branch: main
    revision: HEAD

    URI: git://git.openembedded.org/meta-openembedded
    branch: main
    revision: HEAD

This layer optionally depends on:

    URI: http://code.qt.io/yocto/meta-qt5.git
    branch: 5.12
    revision: HEAD

If meta-qt5 is present, this layer will provide an opt-in Qt5 API as an
alternative to other Qt5 web-engines such as QtWebKit and QtWebEngine.

**Warning**: The default branch has been renamed to `main` because
[#219](https://github.com/Igalia/meta-webkit/issues/219). The old default
branch (`master`) will still be kept as a mirror of the `main` until February
of 2022 [#220](https://github.com/Igalia/meta-webkit/issues/220). Please update
any external reference from `master` to `main` as soon as possible.

Building the WPE engine or WebKitGTK+
=====================================

Please refer to the project Wiki for a detailed guide:

   - WiKi: https://github.com/Igalia/meta-webkit/wiki

How to contribute
=====================================
Contributions are welcomed. Please send your patches as
[Pull Requests](https://github.com/Igalia/meta-webkit/pulls) or fill a
[Issue report](https://github.com/Igalia/meta-webkit/issues) in case you need
to ask for help.
