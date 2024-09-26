package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.StringUtils.given
import adventofcode.utils.SeqUtils.given
import adventofcode.utils.TupleUtils.given
import adventofcode.{Answer, Problem}

import scala.language.implicitConversions

object Problem11 extends Problem {
  private def parseGalaxies(input: String, multiplier: Int) = {
    val grid = input.grid

    def expansions(list: Seq[Seq[Char]]) = list
      .zipWithIndex
      .filter((line, _) => line.forall(_ == '.'))
      .map((_, i) => i)
      .toSet

    def distance(expansionIndices: Set[Int])(from: Int, to: Int) =
      val (min, max) = if from <= to then (from, to) else (to, from)
      val expansions = (min + 1 until max).count(expansionIndices.contains)
      max - min + expansions * (multiplier - 1).toLong

    val yDist = distance(expansions(grid))
    val xDist = distance(expansions(grid.transpose))

    grid
      .locateWhere(_ == '#')
      .combinations(2)
      .map {
        case Seq(a, b) => xDist(a._2, b._2) + yDist(a._1, b._1)
      }
      .sum
  }

  override def part1(input: String): Answer = {
    parseGalaxies(input, 2)
  }

  override def part2(input: String): Answer = {
    parseGalaxies(input, 1000000)
  }
}
