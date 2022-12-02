package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.{Answer, Input, Problem}

import scala.language.implicitConversions

object Problem1 extends Problem {
  override def part1(input: Input): Answer = {
    input
      .toSubInputs
      .map(_
        .lines
        .map(_.toInt)
        .sum
      )
      .max
  }

  override def part2(input: Input): Answer = {
    input
      .toSubInputs
      .map(_
        .lines
        .map(_.toInt)
        .sum
      )
      .sorted
      .takeRight(3)
      .sum
  }
}
