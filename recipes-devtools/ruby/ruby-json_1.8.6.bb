#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "JSON implementation for Ruby"
DESCRIPTION = "A Ruby library providing a complete implementation of the JSON specification (RFC 4627). It enables parsing and generation of JSON data structures, allowing conversion between Ruby objects and JSON documents efficiently and with full Unicode support."
HOMEPAGE = "https://github.com/ruby/json"

LICENSE = "Ruby"
# nooelint: oelint.var.licenseremotefile:License-File - to be properly fixed
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Ruby;md5=105fc57d3f4d3122db32912f3e6107d0"

inherit ruby

DEPENDS += "\
    ruby \
    virtual/crypt \
"

SRC_URI = "git://github.com/flori/json.git;protocol=https;branch=v1.8;destsuffix=${BP}"
SRCREV = "7f4cfd853f2c919d854fb95548a19980feff17e8"

RUBY_GEM_NAME = "json"
RUBY_BUILD_GEMS = "${RUBY_GEM_NAME}.gemspec"
RUBY_INSTALL_GEMS ?= "${RUBY_GEM_NAME}-${PV}.gem"

BBCLASSEXTEND = "native"
