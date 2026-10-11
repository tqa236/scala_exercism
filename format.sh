#!/usr/bin/env bash
set -euo pipefail

# Format all tracked Scala sources with scalafmt.
#
# Usage:
#   ./format.sh          format the sources in place
#   ./format.sh --check  report unformatted files without writing (used by CI)

if ! command -v scalafmt >/dev/null 2>&1; then
  echo "scalafmt is required; install it with 'cs install scalafmt' or 'coursier install scalafmt'." >&2
  exit 127
fi

mode="${1:-}"
if [[ "$#" -gt 1 || (-n "$mode" && "$mode" != "--check") ]]; then
  echo "Usage: $0 [--check]" >&2
  exit 2
fi

files=()
while IFS= read -r file; do
  # Exercism provides the tests for each exercise; keep them byte-for-byte as
  # downloaded and only format the solutions and build definitions.
  [[ "$file" == */src/test/* ]] && continue
  files+=("$file")
done < <(git ls-files -z -- '*.scala' '*.sbt' | tr '\0' '\n')

if ((${#files[@]} == 0)); then
  echo "No tracked Scala files found." >&2
  exit 0
fi

if [[ "$mode" == "--check" ]]; then
  if scalafmt --test "${files[@]}"; then
    echo "All ${#files[@]} Scala file(s) are formatted correctly."
  else
    echo "The file(s) above are not formatted. Run './format.sh' to fix them." >&2
    exit 1
  fi
else
  scalafmt "${files[@]}"
  echo "Formatted ${#files[@]} Scala file(s)."
fi
