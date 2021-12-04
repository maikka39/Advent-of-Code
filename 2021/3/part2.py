#!/usr/bin/env python3
import numpy as np

with open("input.txt", "r") as file:
    data = file.readlines()

numbers = [[int(n) for n in line.strip()] for line in data]

answer = 1
for preferred_bit, method in [[1, np.argmax], [0, np.argmin]]:
    bytes = numbers.copy()
    for index in range(len(bytes)):
        count = list(map(np.bincount, np.transpose(bytes)))[index]
        is_correct_bit = method(
            count) if count[0] != count[1] else preferred_bit
        bytes = [bits for bits in bytes if bits[index] == is_correct_bit]
        if len(bytes) == 1:
            break

    ans = 0
    for bit in bytes[0]:
        ans = (ans << 1) | bit

    answer *= ans

print(answer)
