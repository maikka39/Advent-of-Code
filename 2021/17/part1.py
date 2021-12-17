#!/usr/bin/env python3
with open("input.txt", "r") as file:
    data = [
        list(map(int, axis_range[2:].split("..")))
        for axis_range in file.read()[13:].split(", ")
    ]

x_range, y_range = data

y_target = abs(y_range[0])
print(y_target * (y_target - 1) // 2)
