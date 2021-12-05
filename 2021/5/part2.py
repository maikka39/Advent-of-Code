#!/usr/bin/env python3
from itertools import zip_longest
from dataclasses import dataclass
from typing import List

with open("input.txt", "r") as file:
    data = file.readlines()


@dataclass
class Point:
    x: int
    y: int


@dataclass
class Line:
    start: Point
    end: Point

    def get_intersecting_points(self) -> List[Point]:
        step = 1 if self.start.x < self.end.x else -1
        xs = [x for x in range(self.start.x, self.end.x+step, step)]
        step = 1 if self.start.y < self.end.y else -1
        ys = [y for y in range(self.start.y, self.end.y+step, step)]

        fillvalue = ys[0] if len(ys) < len(xs) else xs[0]

        return [Point(x, y) for x, y in zip_longest(xs, ys, fillvalue=fillvalue)]


lines = [Line(*[Point(*list(map(int, value.split(","))))
              for value in (raw_line.strip().split(" -> "))])
         for raw_line in data]

largest = Point(0, 0)
for line in lines:
    for point in [line.start, line.end]:
        largest.x = max(largest.x, point.x)
        largest.y = max(largest.y, point.y)

intersections = [0] * (largest.x+1) * (largest.y+1)

for line in lines:
    for point in line.get_intersecting_points():
        intersections[point.y*(largest.x+1)+point.x] += 1


print(sum(x >= 2 for x in intersections))
