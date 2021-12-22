#!/usr/bin/env python3
from __future__ import annotations

from dataclasses import dataclass, field
from typing import List, Optional, Tuple

with open("input.txt", "r") as file:
    data: List[Tuple[bool, Tuple[int, int], Tuple[int, int], Tuple[int, int]]] = [
        (line.split(" ")[0] == "on",
         tuple(map(int, line.split("=")[1][:-2].split(".."))),
         tuple(map(int, line.split("=")[2][:-2].split(".."))),
         tuple(map(int, line.strip().split("=")[3].split(".."))))
        for line in file.readlines()]


@dataclass
class Cuboid:
    x_range: Tuple[int, int]
    y_range: Tuple[int, int]
    z_range: Tuple[int, int]
    vacuums: List[Cuboid] = field(default_factory=list)

    def remove(self, other: Cuboid) -> None:
        intersection_cuboid = self.intersect(other)
        if not intersection_cuboid:
            return
        for vacuum in self.vacuums:
            vacuum.remove(intersection_cuboid)
        self.vacuums.append(intersection_cuboid)

    def intersect(self, other: Cuboid) -> Optional[Cuboid]:
        x_range = Cuboid._intersect_ranges(self.x_range, other.x_range)
        y_range = Cuboid._intersect_ranges(self.y_range, other.y_range)
        z_range = Cuboid._intersect_ranges(self.z_range, other.z_range)
        if not all([x_range, y_range, z_range]):
            return None
        return Cuboid(x_range, y_range, z_range)

    @staticmethod
    def _intersect_ranges(a: Tuple[int, int], b: Tuple[int, int]):
        a1, a2 = a
        b1, b2 = b
        if b1 > a2 or a1 > b2:
            return None
        nums = sorted([a1, a2, b1, b2])
        return (nums[1], nums[2])

    @property
    def volume(self) -> int:
        (x1, x2), (y1, y2), (z1, z2) = self.x_range, self.y_range, self.z_range
        return (x2 - x1 + 1) * (y2 - y1 + 1) * (z2 - z1 + 1) - sum(vacuum.volume for vacuum in self.vacuums)


cuboids: List[Cuboid] = []
for on, x_range, y_range, z_range in data:
    new_cuboid = Cuboid(x_range, y_range, z_range)
    for cuboid in cuboids:
        cuboid.remove(new_cuboid)
    if on:
        cuboids.append(new_cuboid)

print(sum(cuboid.volume for cuboid in cuboids))
