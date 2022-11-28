package adventofcode.problems

import adventofcode.Problem

object Problem1 extends Problem {
  override def part1(input: List[String]): String = {
    input
      .map(_.toInt)
      .combinations(2)
      .find(comb => comb.sum == 2020)
      .get
      .product
      .toString
  }

  override def part2(input: List[String]): String = {
    input
      .map(_.toInt)
      .combinations(3)
      .find(comb => comb.sum == 2020)
      .get
      .product
      .toString
  }
}
