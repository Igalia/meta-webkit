inherit meson

PACKAGECONFIG[dbus] = "-Dcog_dbus_control=system -Dcog_dbus_system_owner=${COG_DBUS_OWN_USER},-Dcog_dbus_control=user"
PACKAGECONFIG[drm] = ",,wpebackend-fdo libdrm virtual/libgbm libinput"
PACKAGECONFIG[gtk4] = ",,gtk4"
PACKAGECONFIG[headless] = ",,wpebackend-fdo"
PACKAGECONFIG[soup2] = "-Dsoup2=enabled,-Dsoup2=disabled,libsoup-2.4"
PACKAGECONFIG[weston-direct-display] = "-Dwayland_weston_direct_display=true,-Dwayland_weston_direct_display=false,weston"
PACKAGECONFIG[wl] = ",,wpebackend-fdo"

# libsoup-3 is not available before Poky kirkstone.
# http://git.yoctoproject.org/cgit/cgit.cgi/poky/commit/meta/recipes-support/libsoup/libsoup_3.0.1.bb?id=de296e2b2be876ca5cf2af309b710111e2b2581e
PACKAGECONFIG:append = " ${@bb.utils.contains_any('LAYERSERIES_CORENAMES', 'dunfell gatesgarth hardknott honister', 'soup2', '', d)}"

# possible platforms: drm, headless, wayland (COG_PLATFORM_WL)
python __anonymous() {
    packageconfig = (d.getVar("PACKAGECONFIG") or "").split()
    available_platforms = {'drm': 'drm', 'gtk4': 'gtk4', 'headless': 'headless', 'wl': 'wayland'}
    platforms = [platform for flag, platform in available_platforms.items() if flag in packageconfig]
    if platforms:
        d.appendVar("EXTRA_OEMESON", f" -Dplatforms={','.join(platforms)}")
}

