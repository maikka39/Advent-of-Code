package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.StringUtils.given
import adventofcode.{Answer, Problem}
import adventofcode.utils.TupleUtils.IntTupleImprovements
import adventofcode.utils.SeqUtils.Seq2dImprovements

import scala.language.implicitConversions

object Problem3 extends Problem {
  private def findNumbers(input: String) = {
    input
      .splitLines
      .map("\\d+".r.findAllMatchIn(_).toList)
      .zipWithIndex
      .flatMap((lm, y) => lm.map(m => (m.matched.toInt, (m.start until m.end).map((y, _)))))
  }

  override def part1(input: String): Answer = {
    val grid = input.grid

    findNumbers(input)
      .map((n, posSeq) => (n, posSeq
        .flatMap(_
          .neighborsDiagonal(grid)
          .filter(!posSeq.contains(_))
          .filterNot(grid(_) == '.')
        )
      ))
      .filterNot((_, positions) => positions.isEmpty)
      .map((value, _) => value)
      .sum
  }

  override def part2(input: String): Answer = {
    val grid = input.grid

    findNumbers(input)
      .map((n, posSeq) => (n, posSeq
        .flatMap(_
          .neighborsDiagonal(grid)
          .filter(!posSeq.contains(_))
          .filter(grid(_) == '*')
        )
        .toSet
      ))
      .filterNot((_, positions) => positions.isEmpty)
      .flatMap((value, positions) => positions.map((_, value)))
      .groupBy(_._1)
      .view
      .mapValues(_.map(_._2))
      .filter((_, numbers) => numbers.size >= 2)
      .map(_._2.product)
      .sum
  }
}
