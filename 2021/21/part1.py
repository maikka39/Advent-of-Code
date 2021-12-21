#!/usr/bin/env python3
from itertools import count

with open("input.txt", "r") as file:
    data = [int(line.strip().split(": ")[1]) for line in file.readlines()]

locations = data
scores = [0, 0]

player = 0
for n in count(0, 3):
    locations[player] = (
        locations[player] + n % 100 + (n + 1) % 100 + (n + 2) % 100 + 2) % 10 + 1
    scores[player] += locations[player]
    if scores[player] >= 1000:
        break

    player = not player

print(scores[not player] * (n+3))
