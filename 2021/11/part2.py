#!/usr/bin/env python3
from itertools import count

with open("input.txt", "r") as file:
    data = [[int(n) for n in line.strip()] for line in file.readlines()]


def is_within_bounds(pos):
    x, y = pos
    return 0 <= y < len(data) and 0 <= x < len(data[y])


def neighbours(x, y):
    return filter(is_within_bounds, [(x-1, y-1), (x, y-1), (x+1, y-1), (x-1, y), (x+1, y), (x-1, y+1), (x, y+1), (x+1, y+1)])


def flash_if_possible(x, y, flashed):
    if data[y][x] <= 9 or (x, y) in flashed:
        return

    flashed.add((x, y))

    for nx, ny in neighbours(x, y):
        data[ny][nx] += 1

    for nx, ny in neighbours(x, y):
        flash_if_possible(nx, ny, flashed)


for step in count(1):
    for iy, line in enumerate(data):
        for ix, n in enumerate(line):
            data[iy][ix] += 1

    flashed = set()

    for iy, line in enumerate(data):
        for ix, n in enumerate(line):
            flash_if_possible(ix, iy, flashed)

    for x, y in flashed:
        data[y][x] = 0

    if len(data)*len(data[0]) == len(flashed):
        print(step)
        break
