#!/usr/bin/env python3
with open("input.txt", "r") as file:
    data = list(map(int, file.readlines()[0].split(",")))

days = 80

for _ in range(days):
    for index in range(len(data)):
        data[index] -= 1

        if data[index] < 0:
            data[index] = 6
            data.append(8)

print(len(data))
