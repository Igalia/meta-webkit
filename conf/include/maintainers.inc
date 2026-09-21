# meta-webkit recipe maintainers and automatic upgrade policy
#
# This file is the metadata the auto-upgrade-helper (AUH) needs to decide what
# it may upgrade on its own. Two variables drive that decision:
#
#   RECIPE_MAINTAINER:pn-<recipe>
#       Owner of the recipe. AUH skips every recipe without a maintainer, so a
#       recipe missing from this list is never upgraded automatically.
#
#   RECIPE_NO_UPDATE_REASON:pn-<recipe>
#       Opts a recipe out of the automatic upgrades. The text shows up in the
#       AUH report, so it has to say why the version is not tracked upstream.
#
# The file takes no part in a normal build. It is pulled in by
# conf/templates/template/presets/auh.conf, the preset the nightly upgrade job
# builds its environment with, and can be required from local.conf to run AUH
# or 'devtool check-upgrade-status' by hand.
#
# Image and packagegroup recipes are deliberately absent: they carry no
# upstream version, so there is nothing for AUH to check.
#
# Please keep every list in alphabetical order.

RECIPE_MAINTAINER:pn-browserperfrunner = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-cog = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-hyphen = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-libarchive-zip-perl = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-libwpe = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-openxr = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-python-is-python3 = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-ruby-highline = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-ruby-json = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-sparkle-cdm = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-test-dicts = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-waylandeglinfo = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-webkitgtk = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-webkit-test-fonts = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-woff2 = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-wpebackend-fdo = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-wpebackend-rdk = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-wpe-testbed = "Pablo Saavedra <psaavedra@igalia.com>"
RECIPE_MAINTAINER:pn-wpewebkit = "Pablo Saavedra <psaavedra@igalia.com>"

# The WPE WebKit stack moves as a whole. The ports are updated by
# .github/scripts/do-release.sh and the series that goes with them is pinned in
# conf/templates/template/presets/wpe-*.conf, so an isolated bump of any of
# these recipes would either be ignored by those pins or break the combination.
RECIPE_NO_UPDATE_REASON:pn-cog = "Released with the WPE WebKit series pinned in presets/wpe-*.conf"
RECIPE_NO_UPDATE_REASON:pn-libwpe = "Series pinned in presets/wpe-*.conf"
RECIPE_NO_UPDATE_REASON:pn-webkitgtk = "Updated by .github/scripts/do-release.sh"
RECIPE_NO_UPDATE_REASON:pn-wpebackend-fdo = "Series pinned in presets/wpe-*.conf"
RECIPE_NO_UPDATE_REASON:pn-wpebackend-rdk = "Upstream tags are not comparable with the packaged version"
RECIPE_NO_UPDATE_REASON:pn-wpewebkit = "Updated by .github/scripts/do-release.sh"

# Recipes that follow a SRCREV instead of an upstream release, plus the one
# recipe with no upstream at all. Moving these is a decision about which
# revision the layer ships, not a version bump.
RECIPE_NO_UPDATE_REASON:pn-browserperfrunner = "Pinned by SRCREV, upstream publishes no releases"
RECIPE_NO_UPDATE_REASON:pn-python-is-python3 = "Local recipe with no upstream source"
RECIPE_NO_UPDATE_REASON:pn-ruby-highline = "Pinned by SRCREV to the 1.7.3 gem"
RECIPE_NO_UPDATE_REASON:pn-ruby-json = "Pinned by SRCREV to the 1.8 series"
RECIPE_NO_UPDATE_REASON:pn-sparkle-cdm = "Pinned by SRCREV, upstream publishes no releases"
RECIPE_NO_UPDATE_REASON:pn-test-dicts = "Pinned by SRCREV, upstream publishes no releases"
RECIPE_NO_UPDATE_REASON:pn-waylandeglinfo = "Pinned by SRCREV, upstream publishes no releases"
RECIPE_NO_UPDATE_REASON:pn-webkit-test-fonts = "Pinned by SRCREV, upstream publishes no releases"
RECIPE_NO_UPDATE_REASON:pn-woff2 = "Pinned by SRCREV to a revision ahead of the 1.0.2 tag"
RECIPE_NO_UPDATE_REASON:pn-wpe-testbed = "Pinned by SRCREV, upstream publishes no releases"
