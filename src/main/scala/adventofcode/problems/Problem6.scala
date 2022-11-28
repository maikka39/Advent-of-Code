package adventofcode.problems

import adventofcode.Problem

object Problem6 extends Problem {
  override def part1(input: List[String]): String = {
    input
      .mkString("\n")
      .split("\n\n")
      .map(_
        .replace("\n", "")
        .split("")
        .toSet
        .size)
      .sum
      .toString
  }

  override def part2(input: List[String]): String = {
    input
      .mkString("\n")
      .split("\n\n")
      .map(_
        .split('\n')
        .map(_
          .split("")
          .toSet
        )
        .reduce((a, b) => a.intersect(b))
        .size
      )
      .sum
      .toString
  }
}

