#!/usr/bin/env python3
from __future__ import annotations

from dataclasses import dataclass
from functools import reduce
from math import ceil, floor
from operator import add
from typing import Optional, Union

with open("input.txt", "r") as file:
    data = [eval(line) for line in file.readlines()]


@dataclass
class SnailfishNumber:
    left: Union[SnailfishNumber, int]
    right: Union[SnailfishNumber, int]
    parent: Optional[SnailfishNumber] = None

    def __add__(self, other: SnailfishNumber) -> SnailfishNumber:
        number = SnailfishNumber(self, other)
        self.parent = number
        other.parent = number
        return number.reduce()

    def __eq__(self, other: Union[SnailfishNumber, int]) -> bool:
        if type(other) == int:
            return False
        return self is other

    def __repr__(self) -> str:
        return f"[{self.left},{self.right}]"

    def reduce(self) -> SnailfishNumber:
        while True:
            if self.explode():
                continue
            if not self.split():
                break
        return self

    def depth(self) -> int:
        left_depth = self.left.depth() if type(self.left) == SnailfishNumber else 0
        right_depth = self.right.depth() if type(self.right) == SnailfishNumber else 0

        return max(left_depth, right_depth) + 1

    def _find_number_to_explode(self, depth=4) -> SnailfishNumber:
        if depth == 0:
            return self

        return (self.left if type(self.left) == SnailfishNumber and self.left.depth() >= depth else self.right)._find_number_to_explode(depth-1)

    def explode(self) -> bool:
        if self.depth() <= 4:
            return False

        number = self._find_number_to_explode()

        number.parent.add_left(number.left, number)
        number.parent.add_right(number.right, number)

        if number.parent.left == number:
            number.parent.left = 0
        elif number.parent.right == number:
            number.parent.right = 0

        return True

    def add_left(self, n: int, origin: SnailfishNumber, allow_switch=True) -> None:
        if self.left == origin:
            if self.parent:
                self.parent.add_left(n, self, allow_switch)
            return

        if type(self.left) == SnailfishNumber:
            if allow_switch:
                self.left.add_right(n, self, False)
            else:
                self.left.add_left(n, self, allow_switch)
            return

        self.left += n

    def add_right(self, n: int, origin: SnailfishNumber, allow_switch=True) -> None:
        if self.right == origin:
            if self.parent:
                self.parent.add_right(n, self, allow_switch)

            return

        if type(self.right) == SnailfishNumber:
            if allow_switch:
                self.right.add_left(n, self, False)
            else:
                self.right.add_right(n, self, allow_switch)
            return

        self.right += n

    def split(self) -> bool:
        if type(self.left) == int and self.left > 9:
            self.left = SnailfishNumber(
                floor(self.left / 2), ceil(self.left / 2), self)
            return True
        elif type(self.left) == SnailfishNumber and self.left.split():
            return True
        elif type(self.right) == int and self.right > 9:
            self.right = SnailfishNumber(
                floor(self.right / 2), ceil(self.right / 2), self)
            return True
        elif type(self.right) == SnailfishNumber and self.right.split():
            return True

        return False

    def magnitude(self) -> int:
        magnitude = 0
        if type(self.left) == int:
            magnitude += 3*self.left
        elif type(self.left) == SnailfishNumber:
            magnitude += 3*self.left.magnitude()

        if type(self.right) == int:
            magnitude += 2*self.right
        elif type(self.right) == SnailfishNumber:
            magnitude += 2*self.right.magnitude()

        return magnitude

    @staticmethod
    def from_list(lst, parent=None) -> SnailfishNumber:
        number = SnailfishNumber(None, None, parent)

        left, right = [
            SnailfishNumber.from_list(
                n, number) if type(n) == list else n
            for n in lst
        ]

        number.left = left
        number.right = right

        return number


data = [SnailfishNumber.from_list(x) for x in data]

print(reduce(add, data).magnitude())
