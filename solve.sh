#!/bin/sh
die () {
    echo >&2 "$@"
    exit 1
}

check_deps()
{
   [ -x "$(command -v cowsay)" ] || die "Please install \"cowsay\" for this program to work."
   [ -x "$(command -v lolcat)" ] || die "Please install \"lolcat\" for this program to work."
}

display_help()
{
   echo "Solve any solution using this simple script."
   echo
   echo "Syntax: $0 YEAR DAY PART"
   echo "options:"
   echo "h     Print this help."
   echo "r     Print raw output instead of fancy cowsay/lolcat."
   echo "c     Print fancy cowsay/lolcat output instead of raw (default)."
}

check_deps

raw_output=0

while getopts "hrc" option; do
   case $option in
      h)
         display_help
         exit;;
      r)
         raw_output=1
         ;;
      c)
         raw_output=0
         ;;
      *)
         die "Error: Invalid option passed."
         exit;;
   esac
done
shift $((OPTIND-1))

[ "$#" -ne 0 ] || die "No arguments passed, See \"$0 -h\"."
[ "$#" -eq 3 ] || die "3 argument required, $# provided. See \"$0 -h\"."

year=$1
day=$2
raw_part=$3
part="part$3.py"

script_path=$(readlink -f "$0")
script_location=$(dirname "$script_path")

cd "$script_location"

echo $year | grep -E -q '^[0-9]+$' || die "Numeric argument required, \"$year\" provided"
echo $day | grep -E -q '^[0-9]+$' || die "Numeric argument required, \"$day\" provided"
echo $raw_part | grep -E -q '^[0-9]+$' || die "Numeric argument required, \"$raw_part\" provided"
[ -d "$year" ] || die "Year \"$year\" not found."
[ -d "$year/$day" ] || die "Day \"$day\" of year \"$year\" not found."
[ -f "$year/$day/$part" ] || die "Part \"$raw_part\" for day \"$day\" of year \"$year\" not found."

cd "$year/$day/"

[ $raw_output == 1 ] && ./$part
[ $raw_output == 0 ] && printf "Answer:\n\n$(./$part)" | cowsay -n -f "$(cowsay -l | tail -n +2 | tr ' ' '\n' | sort -R | head -n 1)" | lolcat
