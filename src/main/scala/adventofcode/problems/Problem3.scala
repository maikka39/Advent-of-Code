package adventofcode.problems

import adventofcode.Problem

object Problem3 extends Problem {
  private def isTree(input: List[String], x: Int, y: Int): Boolean = {
    if (y >= input.size)
      false
    else
      input(y)(x % input(y).length) == '#'
  }

  override def part1(input: List[String]): String = {
    val slope = 3 -> 1

    input
      .indices
      .count(i => isTree(input, slope._1 * i, slope._2 * i))
      .toString
  }

  override def part2(input: List[String]): String = {
    val slopes = 1 -> 1 :: 3 -> 1 :: 5 -> 1 :: 7 -> 1 :: 1 -> 2 :: Nil

    slopes.map(slope =>
      input
        .indices
        .count(i => isTree(input, slope._1 * i, slope._2 * i))
    )
      .product
      .toString
  }
}

