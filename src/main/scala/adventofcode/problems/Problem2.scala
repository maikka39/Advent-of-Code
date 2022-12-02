package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.NumberUtils.*
import adventofcode.{Answer, Input, Problem}

import scala.language.implicitConversions

object Problem2 extends Problem {
  override def part1(input: Input): Answer = {
    input
      .lines
      .map(round => {
        val opponent = round.head - 'A' + 1
        val you = round.last - 'X' + 1

        you + (you - opponent + 1) %% 3 * 3
      })
      .sum
  }

  override def part2(input: Input): Answer = {
    input
      .lines
      .map(round => {
        val opponent = round.head - 'A' + 1
        val result = round.last - 'X' + 1

        ((opponent + result) %% 3 + 1) + ((result - 1) * 3)
      })
      .sum
  }
}
