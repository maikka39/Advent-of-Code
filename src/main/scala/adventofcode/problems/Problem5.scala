package adventofcode.problems

import adventofcode.Problem

import scala.annotation.tailrec

object Problem5 extends Problem {
  @tailrec
  private def unpackBsp(encoded: String, low: Int, high: Int, lower: Char): Int = {
    if (encoded.isEmpty)
      low
    else if (encoded.charAt(0) == lower) unpackBsp(encoded.drop(1), low, high - (high - low) / 2, lower)
    else unpackBsp(encoded.drop(1), low + (high - low + 1) / 2, high, lower)
  }

  private def passToId(pass: String) = {
    val rowEncoded = pass.take(7)
    val columnEncoded = pass.takeRight(3)

    val row = unpackBsp(rowEncoded, 0, 127, 'F')
    val column = unpackBsp(columnEncoded, 0, 7, 'L')

    row * 8 + column
  }

  override def part1(input: List[String]): String = {
    input
      .map(passToId)
      .max
      .toString
  }

  override def part2(input: List[String]): String = {
    val ids = input.map(passToId)

    (0 to 127*8+7).diff(ids)
      .find(n => ids.contains(n - 1) && ids.contains(n+1))
      .get
      .toString
  }
}

