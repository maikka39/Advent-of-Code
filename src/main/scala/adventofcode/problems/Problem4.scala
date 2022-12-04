package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.{Answer, Input, Problem}

import scala.language.implicitConversions

object Problem4 extends Problem {
  override def part1(input: Input): Answer = {
    input
      .lines
      .map(l => l.split(','))
      .count(l => {
        val Array(a, b, c, d) = l.flatMap(_.split('-')).map(_.toInt)
        (a >= c && b <= d) || (c >= a && d <= b)
      })
  }

  override def part2(input: Input): Answer = {
    input
      .lines
      .map(l => l.split(','))
      .count(l => {
        val Array(a, b, c, d) = l.flatMap(_.split('-')).map(_.toInt)
        b >= c && d >= a
      })
  }
}
