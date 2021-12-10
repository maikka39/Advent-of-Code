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
    ")": 1,
    "]": 2,
    "}": 3,
    ">": 4,
}

missing_chars_per_line = []

for line in data:
    stack = []

    for char in line:
        if char in brackets:
            stack.append(char)
            continue

        if char != brackets[stack.pop()]:
            break
    else:
        missing_chars_per_line.append([brackets[char]
                                       for char in reversed(stack)])

scores = []
for missing_chars in missing_chars_per_line:
    score = 0
    for char in missing_chars:
        score *= 5
        score += points[char]
    scores.append(score)

print(sorted(scores)[len(scores)//2])
