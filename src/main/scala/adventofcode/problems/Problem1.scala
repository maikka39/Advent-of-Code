package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.{Answer, Input, Problem}
import adventofcode.utils.StringUtils.StringImprovements
import adventofcode.utils.NumberUtils.IntUtils
import adventofcode.utils.SeqUtils.SeqImprovements
import adventofcode.utils.IterableUtils.IterableImprovements

import scala.language.implicitConversions

object Problem1 extends Problem {
  override def part1(input: Input): Answer = {
    input
      .lines
      .map(_.shortInts)
      .map(ints => ints.head.concat(ints.last))
      .sum
  }

  override def part2(input: Input): Answer = {
    val digits = List("one", "two", "three", "four", "five", "six", "seven", "eight", "nine").zip(1 to 9).toMap

    input
      .lines
      .map(line =>
        digits.flatMap(_._1.r.findAllMatchIn(line)).map(m => (m.start, digits(m.matched)))
          ++ "\\d".r.findAllMatchIn(line).map(m => (m.start, m.matched.toInt)))
      .map(_.toList)
      .map(matches => matches.minBy(_._1)._2.concat(matches.maxBy(_._1)._2))
      .sum
  }
}
