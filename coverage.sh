#!/usr/bin/env bash
# Automatically test all exercises
for path in */; do
    [ -d "${path}" ] || continue # if not a directory, skip
    dirname="$(basename "${path}")"
    cp "plugins.sbt" "$dirname/project/plugins.sbt"
    cd "$dirname" || exit
    sbt clean coverage test coverageReport
    cd .. || exit
    exit
done
