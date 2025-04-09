#!/bin/sh -e
# Copyright (c) 2024 Qualcomm Innovation Center, Inc. All rights reserved.
# SPDX-License-Identifier: MIT

TOPDIR=$(realpath $(dirname $(readlink -f $0))/..)

if [ -z $KAS_WORK_DIR ]; then
    echo "KAS_WORK_DIR is empty and it needs to point to populated work dir"
fi

# pybootchartgui tool
CMD="$CMD $KAS_WORK_DIR/oe-core/scripts/pybootchartgui/pybootchartgui.py"
# display time in minutes instead of seconds
CMD="$CMD --minutes"
# image format (png, svg, pdf); default format png
CMD="$CMD --format=svg"
# output path (file or directory) where charts are stored
CMD="$CMD --output=buildchart"
# /path/to/tmp/buildstats/<recipe-machine>/<BUILDNAME>/
CMD="$CMD $KAS_WORK_DIR/build/tmp/buildstats"

exec kas shell $TOPDIR/ci/base.yml --command "$CMD"
