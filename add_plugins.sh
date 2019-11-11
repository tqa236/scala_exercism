#!/usr/bin/env bash
# Automatically test all exercises
for path in */; do
    [ -d "${path}" ] || continue # if not a directory, skip
    dirname="$(basename "${path}")"
    mkdir -p "$dirname/project"
    cp "plugins.sbt" "$dirname/project/plugins.sbt"
done
