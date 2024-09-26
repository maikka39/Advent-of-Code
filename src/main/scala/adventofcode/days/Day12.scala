package adventofcode.days

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.FunctionUtils.memoize
import adventofcode.utils.StringUtils.given
import adventofcode.{Answer, Day}

import scala.collection.mutable
import scala.language.implicitConversions

object Day12 extends Day {
  private val arrangements: ((String, Seq[Int])) => Long = memoize { (line, sizes) =>
    if (sizes.isEmpty)
      if (line.contains('#'))
        0
      else
        1
    else if (line.length < sizes.head)
      0
    else
      line.head match
        case '.' => arrangements(line.tail, sizes)
        case '#' =>
          val (size, tail) = line.splitAt(sizes.head)
          if (size.contains('.') || tail.nonEmpty && tail.head == '#')
            0
          else
            arrangements('.' +: tail.tail, sizes.tail)
        case '?' => arrangements('.' +: line.tail, sizes) + arrangements('#' +: line.tail, sizes)
  }

  override def part1(input: String): Answer = {
    input
      .splitLines
      .map {
        case s"$springs $sizes" => springs -> sizes.ints
      }
      .map(arrangements)
      .sum
  }

  override def part2(input: String): Answer = {
    input
      .splitLines
      .map {
        case s"$springs $sizes" => Seq.fill(5)(springs).mkString("?") -> Seq.fill(5)(sizes.ints).flatten
      }
      .map(arrangements)
      .sum
  }
}
