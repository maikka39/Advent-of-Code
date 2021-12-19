#!/usr/bin/env python3
from __future__ import annotations
from collections import defaultdict

from dataclasses import dataclass, field
from itertools import combinations, permutations, product
from typing import Iterable, List, Optional, Tuple


@dataclass
class Point:
    x: int
    y: int
    z: int

    def __sub__(self, other: Point) -> Tuple[int, int, int]:
        """Return tuple for in dictionary as hashing classes is very slow"""
        return (self.x - other.x, self.y - other.y, self.z - other.z)

    def __add__(self, other: Point) -> Point:
        return Point(self.x + other.x, self.y + other.y, self.z + other.z)

    def __hash__(self):
        return hash(f"{self.x},{self.y},{self.z}")

    def manhattan_dist(self, other: Point) -> int:
        return abs(self.x - other.x) + abs(self.y - other.y) + abs(self.z - other.z)


@dataclass
class Scanner:
    detected_points: List[Point] = field(default_factory=list)
    location: Optional[Point] = None

    @property
    def rotations(self) -> Iterable[List[Point]]:
        for axis1, axis2, axis3 in permutations(["x", "y", "z"]):
            for sign1, sign2, sign3 in product([-1, 1], repeat=3):
                single_rotation = []

                for point in self.detected_points:
                    axes = {"x": point.x, "y": point.y, "z": point.z}
                    single_rotation.append(
                        Point(axes[axis1] * sign1, axes[axis2] * sign2, axes[axis3] * sign3))

                yield single_rotation

    @property
    def abosolute_points(self) -> List[Point]:
        return [
            point + self.location
            for point in self.detected_points
        ]

    def set_location(self, located_scanner: Scanner) -> bool:
        for rotation in self.rotations:
            counts = defaultdict(int)

            for point_1 in rotation:
                for point_2 in located_scanner.detected_points:
                    # point_2 - point_1 returns a tuple
                    counts[point_2 - point_1] += 1

            for (x, y, z), count in counts.items():
                if count >= 12:
                    self.location = Point(x, y, z) + located_scanner.location
                    self.detected_points = rotation
                    return True

        return False


def add_location_to_scanners(scanners: List[Scanner]):
    located_scanners: List[Scanner] = [None] * len(scanners)
    scanners[0].location = Point(0, 0, 0)
    located_scanners[0] = scanners[0]

    while located_scanners.count(None) != 0:
        for i in range(len(scanners)):
            if located_scanners[i]:
                continue

            unlocated_scanner = scanners[i]

            for located_scanner in (scanner for scanner in located_scanners if scanner):
                found = unlocated_scanner.set_location(located_scanner)

                if not found:
                    continue

                located_scanners[i] = unlocated_scanner

                break

    return located_scanners


with open("input.txt", "r") as file:
    scanners: List[Scanner] = []
    scanner: Scanner = Scanner()
    for line in file.readlines():
        line = line.strip()
        if line == "":
            continue
        elif "scanner" in line:
            if scanner.detected_points:
                scanners.append(scanner)
            scanner = Scanner()
        else:
            scanner.detected_points.append(Point(*map(int, line.split(","))))
    scanners.append(scanner)


add_location_to_scanners(scanners)

dist = 0
for scanner1, scanner2 in combinations(scanners, 2):
    dist = max(dist, scanner1.location.manhattan_dist(scanner2.location))

print(dist)
