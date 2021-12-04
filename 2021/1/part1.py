#!/usr/bin/env python3
with open("input.txt", "r") as file:
    data = [int(x) for x in file.readlines()]

data = [x for i, x in enumerate(data[1:]) if x > data[i]]

print(f"{len(data)=}")
