#!/usr/bin/env python3
from numpy import bincount, roll

with open("input.txt", "r") as file:
    data = list(map(int, file.read().split(",")))

counts = bincount(data, minlength=9)

for _ in range(256):
    counts = roll(counts, -1)
    counts[6] += counts[8]

print(sum(counts))
