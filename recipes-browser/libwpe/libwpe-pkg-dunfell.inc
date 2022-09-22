PACKAGECONFIG ??= "enable-xkb"
PACKAGECONFIG[enable-xkb] = "-DWPE_ENABLE_XKB=ON,-DWPE_ENABLE_XKB=OFF, libxkbcommon"

