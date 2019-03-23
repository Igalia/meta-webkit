#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "An implementation of the JSON specification according to RFC 4627"
DESCRIPTION = "An implementation of the JSON specification according to RFC 4627"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PR = "r0"

BPV = "1.8.6"
PV = "${BPV}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRCREV = "7f4cfd853f2c919d854fb95548a19980feff17e8"

S = "${WORKDIR}/git"

RUBY_GEM_NAME="json"
RUBY_BUILD_GEMS="${RUBY_GEM_NAME}.gemspec"
RUBY_INSTALL_GEMS ?= "${RUBY_GEM_NAME}-${PV}.gem"

SRC_URI = " \
    git://github.com/flori/json.git;protocol=https;branch=v1.8 \
    "

inherit ruby

DEPENDS += " \
    ruby \
    virtual/crypt \
"

BBCLASSEXTEND = "native"
