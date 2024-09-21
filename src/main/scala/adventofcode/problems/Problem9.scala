package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.StringUtils.given
import adventofcode.{Answer, Input, Problem}

import scala.language.implicitConversions

object Problem9 extends Problem {
  private def extrapolate(values: List[Int]): Int = {
    if (values.forall(_ == 0))
      0
    else
      val diffs = values.sliding(2).collect { case List(x, y) => y - x }.toList
      values.last + extrapolate(diffs)
  }

  override def part1(input: Input): Answer = {
    input.lines.map(_.signedInts).map(extrapolate).sum
  }

  override def part2(input: Input): Answer = {
    input.lines.map(_.signedInts.reverse).map(extrapolate).sum
  }
}
