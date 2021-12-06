#!/usr/bin/env python3
with open("input.txt", "r") as file:
    data = file.readlines()

valid = 0

for line in data:
    l = int(line[:line.find("-")])
    h = int(line[line.find("-")+1:line.find(" ")])
    c = line[line.find(" ")+1:line.find(":")]
    s = line[line.rfind(" ")+1:]

    if l <= s.count(c) <= h:
        valid += 1

print(valid)
