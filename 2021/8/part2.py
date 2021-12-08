#!/usr/bin/env python3
with open("input.txt", "r") as file:
    data = [[x.split(" ") for x in line] for line in (
        raw_line.strip().split(" | ") for raw_line in file.readlines())]

valid_numbers = ["abcefg", "cf", "acdeg", "acdfg",
                 "bcdf", "abdfg", "abdefg", "acf", "abcdefg", "abcdfg"]

ans = 0

for entry in data:
    inp, out = entry

    options_for_length = {}

    for digit in inp:
        options_for_length[len(digit)] = options_for_length.get(
            len(digit), set("abcdefg")) & set(digit)

    # a is the inputs for 7 minus the inputs for 1
    a = options_for_length[3] - options_for_length[2]
    # c is the inputs for 1 minus the inputs for all numbers containing 6 segments
    c = options_for_length[2] - options_for_length[6]
    # eg is the inputs for 8 minus the combination of the inputs of 4 and 7
    eg = options_for_length[7] - \
        (options_for_length[4] | options_for_length[3])
    # bd is the inputs for 4 minus the inputs for 1
    bd = options_for_length[4] - options_for_length[2]
    # dg is the inputs for all numbers containing 5 segments minus a
    dg = options_for_length[5] - a
    # cf is the intersection between the inputs for 1 and 7
    cf = options_for_length[2] & options_for_length[3]
    f = cf - c
    g = eg & dg
    e = eg - g
    d = dg - g
    b = bd - d

    layout = {a.pop(): "a", b.pop(): "b", c.pop(): "c",  d.pop(): "d", e.pop(): "e", f.pop(): "f", g.pop(): "g"}

    digits = "".join(str(
        valid_numbers.index("".join(sorted(layout[char] for char in digit)))
    ) for digit in out)

    ans += int(digits)

print(ans)
