#!/usr/bin/env python3
import numpy as np

with open("input.txt", "r") as file:
    data = file.readlines()

bits = np.transpose([[int(n) for n in line.strip()] for line in data])
counts = list(map(np.bincount, bits))

answer = 1
for method in [np.argmax, np.argmin]:
    ans = 0
    for bit in map(method, counts):
        ans = (ans << 1) | bit

    answer *= ans

print(answer)
