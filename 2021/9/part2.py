#!/usr/bin/env python3
from collections import deque
from math import prod

with open("input.txt", "r") as file:
    data = [[int(n) for n in line.strip()] for line in file.readlines()]


def is_within_bounds(pos):
    x, y = pos
    return 0 <= y < len(data) and 0 <= x < len(data[y])


def neighbours(x, y):
    return filter(is_within_bounds, [(x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1)])


def is_low(x, y):
    return all(data[ny][nx] > data[y][x] for nx, ny in neighbours(x, y))


def get_low_points():
    return [(ix, iy)
            for iy, row in enumerate(data)
            for ix, _ in enumerate(row)
            if is_low(ix, iy)]


def is_valid(grid, visited, x, y):
    if visited[y][x]:
        return False

    if grid[y][x] > 8:
        return False

    return True


def bfs(grid, startx, starty):
    size = 0

    queue = deque()
    queue.append((startx, starty))

    visited = [[False for _ in range(len(data[y]))] for y in range(len(data))]
    visited[starty][startx] = True

    while (len(queue) > 0):
        x, y = queue.popleft()
        size += 1

        for adjx, adjy in neighbours(x, y):
            if is_valid(grid, visited, adjx, adjy):
                queue.append((adjx, adjy))
                visited[adjy][adjx] = True

    return size


sizes = sorted(bfs(data, x, y) for x, y in get_low_points())

print(prod(sizes[-3:]))
