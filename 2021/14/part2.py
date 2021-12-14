#!/usr/bin/env python3
from collections import defaultdict


with open("input.txt", "r") as file:
    initial_formula = ""
    formulas = {}
    for line in file.readlines():
        line = line.strip()

        if "->" in line:
            inp, out = line.split(" -> ")
            formulas[inp] = out
        elif line == "":
            continue
        else:
            initial_formula = line


pairs = defaultdict(int)
elems = defaultdict(int)

for i, char in enumerate(initial_formula[:-1]):
    pairs[initial_formula[i:i+2]] += 1
    elems[char] += 1
elems[initial_formula[-1]] += 1


for _ in range(40):
    for comb, count in list(pairs.items()):
        new_elem = formulas.get(comb, "")
        elems[new_elem] += count
        pairs[comb] -= count
        pairs[comb[0] + new_elem] += count
        pairs[new_elem + comb[1]] += count

print(max(elems.values()) - min(elems.values()))
