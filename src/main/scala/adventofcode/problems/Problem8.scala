package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.IteratorUtils.*
import adventofcode.utils.SeqUtils.*
import adventofcode.utils.TupleUtils.*
import adventofcode.{Answer, Input, Problem}

import scala.language.implicitConversions

object Problem8 extends Problem {
  private def rays(grid: Seq[Seq[Int]], row: Int, col: Int) = {
    val directions = 1 -> 0 :: -1 -> 0 :: 0 -> 1 :: 0 -> -1 :: Nil

    directions
      .map(delta => {
        Iterator.iterate((row, col))(_ + delta)
          .drop(1)
          .takeWhile(grid.isValidIndex)
          .map(grid(_))
      })
  }

  override def part1(input: Input): Answer = {
    val grid = input
      .lines
      .map(_
        .map(_.asDigit)
      )

    val isTreeValid = for (
      (row, i) <- grid.zipWithIndex;
      (value, j) <- row.zipWithIndex
    ) yield rays(grid, i, j).exists(_.forall(_ < value))

    isTreeValid.count(_ == true)
  }

  override def part2(input: Input): Answer = {
    val grid = input
      .lines
      .map(_
        .map(_.asDigit)
      )

    val scenicScores = for (
      (row, i) <- grid.zipWithIndex;
      (value, j) <- row.zipWithIndex
    ) yield rays(grid, i, j).map(_.countTo(_ >= value)).product

    scenicScores.max
  }
}
