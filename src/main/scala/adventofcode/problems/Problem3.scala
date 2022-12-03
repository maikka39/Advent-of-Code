package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.{Answer, Input, Problem}

import scala.language.implicitConversions

object Problem3 extends Problem {
  override def part1(input: Input): Answer = {
    input
      .lines
      .map(l => l.splitAt(l.length / 2))
      .map(comp => comp._1.toSet & comp._2.toSet)
      .map(_.head)
      .map(v => {
        if (v.isUpper)
          v.toInt - 'A' + 27
        else
          v.toInt - 'a' + 1
      })
      .sum
  }

  override def part2(input: Input): Answer = {
    input
      .lines
      .map(_.toSet)
      .grouped(3)
      .map(_.reduce((a, b) => a & b))
      .map(_.head)
      .map(v => {
        if (v.isUpper)
          v.toInt - 'A' + 27
        else
          v.toInt - 'a' + 1
      })
      .sum
  }
}
