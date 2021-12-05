#!/usr/bin/env python3
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
        if self.start.x == self.end.x:
            step = 1 if self.start.y < self.end.y else -1
            return [Point(self.start.x, y) for y in range(self.start.y, self.end.y+step, step)]
        elif self.start.y == self.end.y:
            step = 1 if self.start.x < self.end.x else -1
            return [Point(x, self.start.y) for x in range(self.start.x, self.end.x+step, step)]
        else:
            return []


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
