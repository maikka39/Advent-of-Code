#!/usr/bin/env python3
from itertools import combinations

with open("input.txt", "r") as file:
    data = map(int, file.readlines())

for a, b in combinations(data, 2):
    if a+b == 2020:
        print(a*b)
        break
