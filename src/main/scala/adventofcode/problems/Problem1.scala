package adventofcode.problems

import adventofcode.Problem

object Problem1 extends Problem {
  override def part1(input: List[String]): String = {
    input
      .mkString("\n")
      .split("\n\n")
      .map(_
        .split('\n')
        .map(_.toInt)
        .sum
      )
      .max
      .toString
  }

  override def part2(input: List[String]): String = {
    input
      .mkString("\n")
      .split("\n\n")
      .map(_
        .split('\n')
        .map(_.toInt)
        .sum
      )
      .sorted
      .takeRight(3)
      .sum
      .toString
  }
}
