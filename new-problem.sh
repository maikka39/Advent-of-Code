#!/bin/bash

die() {
  echo >&2 "$@"
  exit 1
}

display_help() {
  echo "Automatically generate boilerplate code for a new problem."
  echo
  echo "Syntax: $0 [OPTIONS] PROBLEM_NUMBER"
  echo "options:"
  echo "h     Print this help."
  echo "f     Ignore existing files."
}

force_flag=0

while getopts "hf" option; do
  case $option in
  h)
    display_help
    exit
    ;;
  f)
    force_flag=1
    ;;
  *)
    die "Error: Invalid option passed."
    exit
    ;;
  esac
done
shift $((OPTIND - 1))

[ "$#" -ne 0 ] || die "No arguments passed, See \"$0 -h\"."
[ "$#" -eq 1 ] || die "1 argument required, $# provided. See \"$0 -h\"."

problem="$1"

script_dir=$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)

source_file_path="$script_dir/src/main/scala/adventofcode/problems/Problem${problem}.scala"
input_folder_path="$script_dir/src/test/resources/input/problem${problem}/"
input_file_path="$input_folder_path/input.txt"
sample_file_path="$input_folder_path/sample.txt"
test_file_path="$script_dir/src/test/scala/adventofcode/problems/Problem${problem}Spec.scala"

if [ -f "$source_file_path" ] || [ -d "$input_folder_path" ] || [ -f "$input_file_path" ] || [ -f "$sample_file_path" ] || [ -f "$test_file_path" ]; then
  [ $force_flag == 0 ] && die "This problem already exists!"
fi

echo -n "package adventofcode.problems

import adventofcode.Problem

object Problem${problem} extends Problem {
  override def part1(input: List[String]): String = {
    0.toString
  }

  override def part2(input: List[String]): String = {
    0.toString
  }
}
" >"$source_file_path"

mkdir -p "$input_folder_path"

echo -n "" >"$input_file_path"
echo -n "" >"$sample_file_path"

echo -n "package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem${problem}Spec extends AnyWordSpec with Matchers with TestUtils {
  \"part 1\" should {
    \"solve the sample input\" in {
      Problem${problem}.part1(getInput(${problem}, \"sample.txt\")) shouldBe \"\"
    }

    \"solve the actual input\" in {
      Problem${problem}.part1(getInput(${problem}, \"input.txt\")) shouldBe \"\"
    }
  }

  \"part 2\" should {
    \"solve the sample input\" in {
      Problem${problem}.part2(getInput(${problem}, \"sample.txt\")) shouldBe \"\"
    }

    \"solve the actual input\" in {
      Problem${problem}.part2(getInput(${problem}, \"input.txt\")) shouldBe \"\"
    }
  }
}
" >"$test_file_path"

echo "Created Problem${problem}"
