# meta-webkit (OpenEmbedded/Yocto BSP layer for WebKit based browsers)

This layer provides recipes of WebKit based runtimes and browsers for
use with OpenEmbedded and/or Yocto.

This layer depends on:

URI: git://git.openembedded.org/openembedded-core
branch: master
revision: HEAD

URI: git://git.openembedded.org/meta-openembedded
branch: master
revision: HEAD


## Instructions on how to use this layer.

### Building WebKitForWayland.

WebKit for Wayland port pairs the WebKit engine with the Wayland display protocol,
allowing embedders to create simple and performant systems based on Web platform technologies.
It is designed with hardware acceleration in mind, relying on EGL, the Wayland EGL platform, and OpenGL ES.

The usual way to create an image with webkitforwayland is:

  * Checkout the branch of this repository that matches your Yocto/OE version (for example: fido)
  * Add this layer to bblayers.conf
  * Add the following to local.conf:
```
DISTRO_FEATURES_append = " opengl wayland"
IMAGE_INSTALL_append = " webkitforwayland"
```
  * Then build the target image, for example:
```
bitbake core-image-weston
```
  * Run WPELauncher from a weston terminal.

### Building WebKitGTK+

WebKitGTK+ is a full-featured port of the WebKit rendering engine, suitable for projects
requiring any kind of web integration, from hybrid HTML/CSS applications to full-fledged
web browsers. It offers WebKit’s full functionality and is useful in a wide range of
systems from desktop computers to embedded systems like phones, tablets, and televisions.

The usual way to create an image with webkitgtk is:

  * The package webkitgtk contains the shared libraries and the webkitgtk runtime.
  * The package webkitgtk-bin contains the MiniBrowser executable.
  * There are several packageconfig options that you can tune.
  * The name of the recipe is the same than the one available in oe-core (master),
    so you should select which version of webkitgtk you want to build in your local.conf
    like:
```
DISTRO_FEATURES_append = " opengl x11"
PACKAGECONFIG_pn-webkitgtk = "x11 webgl"
IMAGE_INSTALL_append = " webkitgtk-bin"
PREFERRED_VERSION_webkitgtk = "2.10.2"
```
  * Then build the X11 image
```
bitbake core-image-sato
```
  * Run MiniBrowser (or another browser based on webkitgtk+) from an X terminal.