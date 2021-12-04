#!/usr/bin/env python3
with open("input.txt", "r") as file:
    data = [int(x) for x in file.readlines()]

data = [data[i] + data[i+1] + data[i+2] for i in range(len(data) - 2)]
data = [x for i, x in enumerate(data[1:]) if x > data[i]]

print(f"{len(data)=}")
