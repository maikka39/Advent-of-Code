#!/usr/bin/env python3
from math import ceil, floor
from statistics import mean

with open("input.txt", "r") as file:
    data = list(map(int, file.read().split(",")))

lower = floor(mean(data))
upper = ceil(mean(data))


def count_cost(n): return (n*n+n)//2


cost = min(
    sum(count_cost(abs(pos - lower)) for pos in data),
    sum(count_cost(abs(pos - upper)) for pos in data)
)

print(cost)
