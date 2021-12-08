#!/usr/bin/env python3
with open("input.txt", "r") as file:
    data = [[x.split(" ") for x in line] for line in (
        raw_line.strip().split(" | ") for raw_line in file.readlines())]

ans = sum(1 for inp, out in data for digit in out if len(
    digit) in [2, 3, 4, 7])

print(ans)
