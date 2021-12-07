#!/usr/bin/env python3
from math import ceil, floor
from statistics import median

with open("input.txt", "r") as file:
    data = list(map(int, file.read().split(",")))

lower = floor(median(data))
upper = ceil(median(data))

cost = min(
    sum(abs(pos - lower) for pos in data),
    sum(abs(pos - upper) for pos in data)
)

print(cost)
