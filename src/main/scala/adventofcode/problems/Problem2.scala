package adventofcode.problems

import adventofcode.Problem

object Problem2 extends Problem {
  override def part1(input: List[String]): String = {
    input
      .map(game => {
        val opponent = game.head - 'A' + 1
        val yours = game.last - 'X' + 1

        val bonusPoints = opponent -> yours match
          case (1, 2) => 6
          case (2, 3) => 6
          case (3, 1) => 6
          case (a, b) => if (a == b) 3 else 0

        yours + bonusPoints
      })
      .sum
      .toString
  }

  override def part2(input: List[String]): String = {
    input
      .map(game => {
        val opponent = game.head - 'A' + 1
        val yours = game.last - 'X' + 1 match
          case 1 => if (opponent - 1 < 1) 3 else opponent - 1
          case 2 => opponent
          case 3 => if (opponent + 1 > 3) 1 else opponent + 1

        val bonusPoints = opponent -> yours match
          case (1, 2) => 6
          case (2, 3) => 6
          case (3, 1) => 6
          case (a, b) => if (a == b) 3 else 0

        yours + bonusPoints
      })
      .sum
      .toString
  }
}
