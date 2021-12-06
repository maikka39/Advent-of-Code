#!/usr/bin/env python3
with open("input.txt", "r") as file:
    data = [line.strip() for line in file.readlines()]

slope = 3, 1


def is_tree(x, y):
    return data[y][x % len(data[y])] == "#"


print(sum(is_tree((slope[0])*i, slope[1]*i) for i in range(len(data))))
