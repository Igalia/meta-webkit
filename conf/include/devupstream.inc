# In ./poky/meta/classes/devupstream.bbclass, the PV is defined as follows:
#
#   # Modify the PV if the recipe hasn't already overridden it
#   pv = d.getVar("PV")
#   proto_marker = "+" + uri.scheme
#   if proto_marker not in pv:
#       d.setVar("PV", pv + proto_marker + "${SRCPV}")
#
# For preferred viersion like:
#
#   PREFERRED_VERSION_wpewebkit = "2.28.%"
#
# ; the devupstream version will be preferred versus the regular version
# because 2.28.4+git... > 2.28.4
#
# We skip this issue by setting the PV value to a slightly diffent version
# resulting of truncating the minor version number (example: 2.28+git).
# The resulting version doesn't match with a three-part version number:
#
#   "2.28+git" doesn't match with "2.28.%".
#
# We can still use "2.28.%" for the release versions and "2.28%" for
# devupstream.

BBCLASSEXTEND += "devupstream:target"

python devupstream_virtclass_handler_prepend () {
    uri = bb.fetch2.URI(d.getVar("SRC_URI").split()[0])
    if uri.scheme == "git":
        d.setVar("S", "${WORKDIR}/git")

    # Trucating the last version number (usually patch).
    pv = ".".join(d.getVar("PV").split(".")[:-1])
    if not pv:
        pv = d.getVar("PV")
    proto_marker = "+" + uri.scheme
    # Modify the PV if the recipe hasn't already overridden it
    if proto_marker not in pv:
        # PV is composed with MAJOR.MINOR, protocol and the hash
        d.setVar("PV", pv + proto_marker + "${SRCPV}")
}

