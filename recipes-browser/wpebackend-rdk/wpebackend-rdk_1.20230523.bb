require wpebackend-rdk.inc

DEPENDS += "libinput"

PROVIDES:append:class-devupstream = " virtual/wpebackend"

PV = "1.20221201"

SRC_URI = "git://github.com/WebPlatformForEmbedded/WPEBackend-rdk.git;protocol=https;branch=master"
SRC_URI:class-devupstream = "git://github.com/WebPlatformForEmbedded/WPEBackend-rdk.git;protocol=https;branch=master"

SRCREV = "108e4ab0da043421202e3ef64e0a38d1db8b82ee"
SRCREV:class-devupstream = "108e4ab0da043421202e3ef64e0a38d1db8b82ee"

RPROVIDES:${PN}:append:class-devupstream = " virtual-wpebackend"

BBCLASSEXTEND += "devupstream:target"

# nooelint: oelint.task.noanonpython - required for backward compatibility with scarthgap
python __anonymous() {
    if not d.getVar('UNPACKDIR'):
        d.setVar('S', d.getVar('WORKDIR') + '/git')
}

