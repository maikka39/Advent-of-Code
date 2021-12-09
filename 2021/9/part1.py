#!/usr/bin/env python3
with open("input.txt", "r") as file:
    data = [[int(n) for n in line.strip()] for line in file.readlines()]


def is_low(x, y):
    return not any(
        0 <= ny < len(data) and 0 <= nx < len(data[ny])
        and data[ny][nx] <= data[y][x]
        for nx, ny in [(x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1)]
    )


print(sum(n+1
          for iy, row in enumerate(data)
          for ix, n in enumerate(row)
          if is_low(ix, iy)))
