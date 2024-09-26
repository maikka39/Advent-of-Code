#!/bin/bash

die() {
  echo >&2 "$@"
  exit 1
}

display_help() {
  echo "Automatically generate boilerplate code for a new day."
  echo
  echo "Syntax: $0 [OPTIONS] DAY_NUMBER"
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

day="$1"

script_dir=$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)

source_file_path="$script_dir/src/main/scala/adventofcode/days/Day${day}.scala"
input_folder_path="$script_dir/src/test/resources/input/day${day}/"
input_file_path="$input_folder_path/input.txt"
sample_file_path="$input_folder_path/sample.txt"
test_file_path="$script_dir/src/test/scala/adventofcode/days/Day${day}Spec.scala"

if [ -f "$source_file_path" ] || [ -d "$input_folder_path" ] || [ -f "$input_file_path" ] || [ -f "$sample_file_path" ] || [ -f "$test_file_path" ]; then
  [ $force_flag == 0 ] && die "This day already exists!"
fi

echo -n "package adventofcode.days

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.StringUtils.given
import adventofcode.{Answer, Day}

import scala.language.implicitConversions

object Day${day} extends Day {
  override def part1(input: String): Answer = {
    0
  }

  override def part2(input: String): Answer = {
    0
  }
}
" >"$source_file_path"

mkdir -p "$input_folder_path"

echo -n "" >"$input_file_path"
echo -n "" >"$sample_file_path"

echo -n "package adventofcode.days

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Day${day}Spec extends AnyWordSpec with Matchers with TestUtils {
  \"part 1\" should {
    \"solve the sample input\" in {
      Day${day}.part1(getInput(${day}, \"sample.txt\")).answer shouldBe \"\"
    }

    \"solve the actual input\" in {
      Day${day}.part1(getInput(${day}, \"input.txt\")).answer shouldBe \"\"
    }
  }

  \"part 2\" should {
    \"solve the sample input\" in {
      Day${day}.part2(getInput(${day}, \"sample.txt\")).answer shouldBe \"\"
    }

    \"solve the actual input\" in {
      Day${day}.part2(getInput(${day}, \"input.txt\")).answer shouldBe \"\"
    }
  }
}
" >"$test_file_path"

echo "Created Day ${day}"
