package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.{Answer, Input, Problem}

import scala.language.implicitConversions

object Problem6 extends Problem {
  override def part1(input: Input): Answer = {
    4 + input.string.sliding(4).indexWhere(w => w.length == w.toSet.size)
  }

  override def part2(input: Input): Answer = {
    14 + input.string.sliding(14).indexWhere(w => w.length == w.toSet.size)
  }
}
