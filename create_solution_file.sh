#!/usr/bin/env bash
# Automatically test all exercises
for path in */; do
    [ -d "${path}" ] || continue # if not a directory, skip
    dirname="$(basename "${path}")"
    cd "$dirname/src/test/scala" || exit
    file_name=$(ls)
    file_name="${file_name/%Test.scala/.scala}"
    cd "../../main/scala" || exit
    touch "$file_name"
    cd ../../../.. || exit
done
