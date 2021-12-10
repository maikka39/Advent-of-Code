#!/usr/bin/env python3
with open("input.txt", "r") as file:
    data = [line.strip() for line in file.readlines()]

brackets = {
    "(": ")",
    "[": "]",
    "{": "}",
    "<": ">",
}

points = {
    ")": 3,
    "]": 57,
    "}": 1197,
    ">": 25137,
}

illegal_chars = []

for line in data:
    stack = []

    for char in line:
        if char in brackets:
            stack.append(char)
            continue

        if char != brackets[stack.pop()]:
            illegal_chars.append(char)
            break

print(sum(points[char] for char in illegal_chars))
