package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.StringUtils.given
import adventofcode.{Answer, Input, Problem}

object Problem6 extends Problem {
  private def winCount(totalTime: Long, recordDistance: Long): Int = {
    def result(holdTime: Long): Boolean = (totalTime - holdTime) * holdTime > recordDistance

    (1L until totalTime).map(result).count(_ == true)
  }

  override def part1(input: Input): Answer = {
    val times :: distances :: Nil = input
      .lines
      .map(_
        .dropWhile(!_.equals(':'))
        .drop(1)
        .longs
      ): @unchecked

    times.zip(distances).map(winCount).product
  }

  override def part2(input: Input): Answer = {
    val totalTime :: record :: Nil = input
      .lines
      .map(_
        .dropWhile(!_.equals(':'))
        .drop(1)
        .replace(" ", "")
        .toLong
      ): @unchecked

    winCount(totalTime, record)
  }
}
