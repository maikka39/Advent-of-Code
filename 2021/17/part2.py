#!/usr/bin/env python3
from math import sqrt, ceil, floor

with open("input.txt", "r") as file:
    data = [
        list(map(int, axis_range[2:].split("..")))
        for axis_range in file.read()[13:].split(", ")
    ]

x_range, y_range = data


def quadratic(a, b, c):
    return max((-b + sqrt(b**2 - (4*a*c))) / (2 * a),
               (-b - sqrt(b**2 - (4*a*c))) / (2 * a))


min_vx_rest = ceil(quadratic(1, 1, -(2 * x_range[0])))
max_vx_rest = floor(quadratic(1, 1, -(2 * x_range[1])))

vel_bounds_y = [y_range[0], abs(y_range[0])-1]

yt = set()

for vy in range(vel_bounds_y[0], vel_bounds_y[1]+1):
    offset = 0
    fvy = vy
    if vy == 0:
        offset = 1
        fvy = -1
    elif vy > 0:
        offset = (2 * vy) + 1
        fvy = -fvy - 1

    min_t = ceil(quadratic(-1, 2 * fvy + 1, -2 * y_range[1]))
    max_t = floor(quadratic(-1, 2 * fvy + 1, -2 * y_range[0]))

    for t in range(min_t, max_t+1):
        yt.add((vy, t + offset))

xt = set()

for t in {t for _, t in yt}:
    min_vx_move = ceil((((2 * x_range[0]) / t) + t - 1) / 2)
    max_vx_move = floor((((2 * x_range[1]) / t) + t - 1) / 2)

    xrange = [x for x in range(max(t, min_vx_move), max_vx_move+1)]

    if min_vx_rest < t:
        xrange += [x for x in range(min_vx_rest, min(t, max_vx_rest)+1)]

    for x in xrange:
        xt.add((x, t))


answers = {(y, x) for x, t1 in xt for y, t2 in yt if t1 == t2}

print(len(answers))
