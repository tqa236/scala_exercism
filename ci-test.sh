#!/usr/bin/env bash
set -uo pipefail

# Run the test suite of every exercise in this repository.
#
# Each exercise is a standalone sbt project, so each one is built and tested in
# its own directory. Exercises that are still unfinished (their solution body is
# `???`, the Scala "not implemented yet" placeholder) are reported as skipped
# rather than failed, so the suite stays green while work is in progress.
#
# Environment:
#   CI_TEST_JOBS  number of exercises to build in parallel (default: nproc)

jobs="${CI_TEST_JOBS:-$(nproc)}"
if ! [[ "$jobs" =~ ^[1-9][0-9]*$ ]]; then
  echo "CI_TEST_JOBS must be a positive integer; got '$jobs'." >&2
  exit 2
fi

if ! command -v sbt >/dev/null 2>&1; then
  echo "sbt is required to run the tests." >&2
  exit 127
fi

repo_root="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$repo_root"

temp_root="$(mktemp -d "${RUNNER_TEMP:-${TMPDIR:-/tmp}}/scala-exercism-tests.XXXXXX")"
log_root="$temp_root/logs"
result_root="$temp_root/results"
mkdir -p "$log_root" "$result_root"
trap 'rm -rf "$temp_root"' EXIT

# `???` marks an exercise whose solution has not been written yet.
is_unfinished() {
  grep -R -q --include='*.scala' '???' "$1/src/main"
}

exercises=()
for build_file in */build.sbt; do
  [[ -f "$build_file" ]] || continue
  exercises+=("${build_file%/build.sbt}")
done

if ((${#exercises[@]} == 0)); then
  echo "No sbt exercise projects found." >&2
  exit 1
fi

run_one() {
  local exercise="$1"
  local name="${exercise##*/}"
  local log_file="$CI_LOG_ROOT/$name.log"

  if {
    cd "$exercise" &&
      sbt -batch -no-colors test
  } >"$log_file" 2>&1; then
    printf '0\n' >"$CI_RESULT_ROOT/$name"
  else
    printf '%s\n' "$?" >"$CI_RESULT_ROOT/$name"
  fi
}

export -f run_one

export CI_LOG_ROOT="$log_root"
export CI_RESULT_ROOT="$result_root"

printf '%s\n' "${exercises[@]}" |
  xargs -r -P "$jobs" -n 1 bash -c 'run_one "$1"' _

xargs_status=$?

passed=0
failed=0
skipped=0
failed_names=()

for exercise in "${exercises[@]}"; do
  name="${exercise##*/}"
  result_file="$result_root/$name"

  if is_unfinished "$exercise"; then
    printf 'SKIP  %s (solution not implemented)\n' "$exercise"
    ((skipped += 1))
    continue
  fi

  if [[ ! -f "$result_file" ]]; then
    printf 'FAIL  %s (worker did not report a result)\n' "$exercise"
    failed_names+=("$exercise")
    ((failed += 1))
    continue
  fi

  status="$(<"$result_file")"
  if [[ "$status" == "0" ]]; then
    ((passed += 1))
  else
    printf 'FAIL  %s (exit %s)\n' "$exercise" "$status"
    failed_names+=("$exercise")
    ((failed += 1))
  fi
done

printf '\nTest summary: %d passed, %d failed, %d skipped, %d total (up to %d in parallel).\n' \
  "$passed" "$failed" "$skipped" "${#exercises[@]}" "$jobs"

if ((failed > 0)); then
  for name in "${failed_names[@]}"; do
    log_file="$log_root/${name##*/}.log"
    echo "::group::Failure details: $name"
    cat "$log_file" 2>/dev/null || echo "(no log produced)"
    echo "::endgroup::"
  done
fi

if ((xargs_status != 0)); then
  echo "One or more test workers could not be started (xargs exit $xargs_status)." >&2
  exit "$xargs_status"
fi

((failed == 0))
