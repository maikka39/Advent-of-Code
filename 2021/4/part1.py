#!/usr/bin/env python3
from dataclasses import dataclass
from typing import Iterable, List
import numpy as np


@dataclass
class Number:
    n: int
    checked: bool = False

    def __eq__(self, other):
        return self.n == other.n


@dataclass
class Board:
    field: List[List[Number]]

    def draw(self, n):
        for line in self.field:
            if Number(n) in line:
                line[line.index(Number(n))].checked = True

    def has_won(self):
        return any(any(len(line) == sum(n.checked == True for n in line) for line in field) for field in [self.field, np.transpose(self.field)])

    def sum_of_unchecked(self):
        return sum(n.n for line in self.field for n in line if n.checked == False)


def get_boards(board_data) -> Iterable[Board]:
    board = []
    for line in board_data:
        line = line.strip()

        if line == "":
            yield Board(board)
            board = []
            continue

        board.append(list(map(Number, map(int, line.strip().split()))))

    yield Board(board)


with open("input.txt", "r") as file:
    data = file.readlines()

drawn_numbers = map(int, data[0].strip().split(","))
boards = list(get_boards(data[2:]))

for n in drawn_numbers:
    for board in boards:
        board.draw(n)

        if board.has_won():
            print(n * board.sum_of_unchecked())
            exit()
