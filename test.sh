#!/usr/bin/env bash
# Automatically test all exercises
for path in */; do
    [ -d "${path}" ] || continue # if not a directory, skip
    dirname="$(basename "${path}")"
    cd "$dirname" || exit
    sbt test
    cd .. || exit
done
