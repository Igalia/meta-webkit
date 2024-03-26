require libwpe.inc
require ${@bb.utils.contains_any("LAYERSERIES_CORENAMES", 'dunfell', 'libwpe-pkg-dunfell.inc', 'libwpe-pkg.inc', d)}

SRC_URI[sha256sum] = "b1d0cdcf0f8dbb494e65b0f7913e357106da9a0d57f4fbb7b9d1238a6dbe9ade"

