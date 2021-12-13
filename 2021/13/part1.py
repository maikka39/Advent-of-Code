#!/usr/bin/env python3
with open("input.txt", "r") as file:
    positions = set()
    foldings = []

    for line in file.readlines():
        line = line.strip()

        if line == "":
            continue
        if line.startswith("fold along"):
            axis, pos = line[line.rfind(" ")+1:].split("=")
            foldings.append((axis, int(pos)))
        else:
            positions.add(tuple(map(int, line.split(","))))

    width = max(positions, key=lambda x: x[0])[0]
    height = max(positions, key=lambda x: x[1])[1]

for axis, line in foldings[:1]:
    if axis == "x":
        axis = 0
        length = width
        width = line-1
    if axis == "y":
        axis = 1
        length = height
        height = line-1

    for position in positions.copy():
        if position[axis] == line:
            positions.remove(position)
            continue

        if position[axis] > line:
            positions.remove(position)

            if axis == 0:
                positions.add(
                    ((length-line)-(position[axis]-line), position[1]))
            else:
                positions.add(
                    (position[0], (length-line)-(position[axis]-line)))


print(len(positions))
