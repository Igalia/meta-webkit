meta-webkit (OpenEmbedded/Yocto layer for WebKit based engines and browsers)
============================================================================

This layer provides recipes of WebKit based runtimes and browsers for
use with OpenEmbedded and/or Yocto.

This layer depends on:

    URI: git://git.openembedded.org/openembedded-core
    branch: master
    revision: HEAD



Building the WebKitForWayland engine.
-------------------------------------


WebKit for Wayland port pairs the WebKit engine with the Wayland display protocol,
allowing embedders to create simple and performant systems based on Web platform technologies.
It is designed with hardware acceleration in mind, relying on EGL, the Wayland EGL platform, and OpenGL ES.

The usual way to create an image with webkitforwayland is:

  * Checkout the branch of this repository that matches your Yocto/OE version (for example: fido)
  * Add this layer to bblayers.conf
  * Add the following to local.conf:

        DISTRO_FEATURES_append = " opengl wayland"
        IMAGE_INSTALL_append = " webkitforwayland"

  * Then build the target image, for example:

        bitbake core-image-weston

  * Run WPELauncher from a weston terminal.

Building the WebKitGTK+ engine.
-------------------------------

WebKitGTK+ is a full-featured port of the WebKit rendering engine, suitable for projects
requiring any kind of web integration, from hybrid HTML/CSS applications to full-fledged
web browsers. It offers WebKit’s full functionality and is useful in a wide range of
systems from desktop computers to embedded systems like phones, tablets, and televisions.

When creating an image with with WebkitGTK+, thake into account:

  * The package webkitgtk contains the shared libraries and the webkitgtk runtime.
  * The package webkitgtk-bin contains the MiniBrowser executable (a very basic browser
    built on top of the webkitgtk runtime, mainly used for testing purposes).
  * The name of the recipe is the same than the one available in oe-core (master),
    so you should select which version of webkitgtk you want to build in your local.conf
  * The webkitgtk recipe has several packageconfig options that you can tune. Check the
    source code of the recipe to see all the ones available. For example, for enabling
    WebGL support you can add the following to your conf/local.conf file:

        PACKAGECONFIG_pn-webkitgtk = "x11 webgl"

  * Add the following lines to your conf/local.conf file (for building the X11 backend of WebKitGTK+) :

        DISTRO_FEATURES_append = " opengl x11"
        IMAGE_INSTALL_append = " webkitgtk-bin"
        PREFERRED_VERSION_webkitgtk = "2.10.3"

  * Then build the X11 image

        bitbake core-image-sato

  * Run MiniBrowser (or another browser based on webkitgtk+) from an X terminal.


Contributing
------------

At your convenience, use either github pull requests <https://github.com/Igalia/meta-webkit/pulls>
or send patches directly to the OpenEmbedded dev mailing list <openembedded-devel@lists.openembedded.org>
and please cc the maintainers.

To send patches to the mailing list, please use something like :

    git send-email -1 --to openembedded-devel@lists.openembedded.org --cc clopez@igalia.com --subject-prefix='meta-webkit][PATCH'


Reporting bugs
--------------

 You can use the github issue tracker <https://github.com/Igalia/meta-webkit/issues>
 or send an email to the OpenEmbedded dev mailing list <openembedded-devel@lists.openembedded.org>
 cc'ing the maintainers.

Maintainers:

    Carlos Alberto Lopez Perez <clopez@igalia.com>


Further info
------------

 The following resources contain useful information:

  * Blog post introducing this meta-webkit layer: http://blog.neutrino.es/2015/meta-webkit-yocto-layer
