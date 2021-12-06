#!/usr/bin/env python3
from itertools import combinations

with open("input.txt", "r") as file:
    data = map(int, file.readlines())

for a, b, c in combinations(data, 3):
    if a+b+c == 2020:
        print(a*b*c)
        break
