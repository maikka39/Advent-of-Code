#!/usr/bin/env python3
import numpy as np
import pyastar2d

with open("input.txt", "r") as file:
    maze = [[int(x) for x in line.strip()] for line in file.readlines()]


def find_path(maze, start, end):
    weights = np.array(maze, dtype=np.float32)
    return pyastar2d.astar_path(weights, start, end)


def transpose(arr):
    return [list(row) for row in zip(*arr)]


def extend_maze(maze):
    for func in [lambda x:x, transpose]:
        maze = func(maze)

        for line in maze:
            orig_line = line.copy()
            for a in range(1, 5):
                line += [n+a if n+a <= 9 else n+a-9 for n in orig_line]

        maze = func(maze)

    return maze


maze = extend_maze(maze)
path = find_path(maze, (0, 0), (len(maze)-1, len(maze[0])-1))

print(sum(maze[y][x] for y, x in path[1:]))
