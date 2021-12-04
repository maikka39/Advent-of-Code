#!/usr/bin/env python3
with open("input.txt", "r") as file:
    data = file.readlines()

horizontal = 0
depth = 0
aim = 0

for line in data:
    direction, amount = line.strip().split(" ")
    amount = int(amount)

    if direction == "forward":
        horizontal += amount
        depth += aim * amount
    elif direction == "up":
        aim -= amount
    elif direction == "down":
        aim += amount

print(horizontal*depth)
