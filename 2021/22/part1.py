#!/usr/bin/env python3
with open("input.txt", "r") as file:
    data = [(line.split(" ")[0] == "on",
             tuple(map(int, line.split("=")[1][:-2].split(".."))),
             tuple(map(int, line.split("=")[2][:-2].split(".."))),
             tuple(map(int, line.strip().split("=")[3].split(".."))))
            for line in file.readlines()]

cubes = set()
for on, x_range, y_range, z_range in data:
    for x in range(max(-50, x_range[0]), min(50, x_range[1])+1):
        for y in range(max(-50, y_range[0]), min(50, y_range[1])+1):
            for z in range(max(-50, z_range[0]), min(50, z_range[1])+1):
                location = (x, y, z)
                if on:
                    cubes.add(location)
                else:
                    cubes.discard(location)

print(len(cubes))
