#!/usr/bin/env python3
from math import prod

with open("input.txt", "r") as file:
    data = [line.strip() for line in file.readlines()]

slopes = [(1, 1), (3, 1), (5, 1), (7, 1), (1, 2)]


def is_tree(x, y):
    if y >= len(data):
        return False
    return data[y][x % len(data[y])] == "#"


print(prod(sum(is_tree((slope[0])*i, slope[1]*i)
      for i in range(len(data))) for slope in slopes))
