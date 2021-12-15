#!/usr/bin/env python3
import numpy as np
import pyastar2d

with open("input.txt", "r") as file:
    maze = [[int(x) for x in line.strip()] for line in file.readlines()]

weights = np.array(maze, dtype=np.float32)
path = pyastar2d.astar_path(weights, (0, 0), (len(maze)-1, len(maze[0])-1))

print(sum(maze[y][x] for y, x in path[1:]))
