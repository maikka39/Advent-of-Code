package adventofcode.days

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.StringUtils.given
import adventofcode.{Answer, Day}

import scala.language.implicitConversions

object Day9 extends Day {
  private def extrapolate(values: List[Int]): Int = {
    if (values.forall(_ == 0))
      0
    else
      val diffs = values.sliding(2).collect { case List(x, y) => y - x }.toList
      values.last + extrapolate(diffs)
  }

  override def part1(input: String): Answer = {
    input.splitLines.map(_.signedInts).map(extrapolate).sum
  }

  override def part2(input: String): Answer = {
    input.splitLines.map(_.signedInts.reverse).map(extrapolate).sum
  }
}
