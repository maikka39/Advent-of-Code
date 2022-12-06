package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.StringUtils.*
import adventofcode.{Answer, Input, Problem}

import scala.collection.immutable.List
import scala.collection.mutable.ListBuffer
import scala.language.implicitConversions

object Problem5 extends Problem {
  private def solve(input: Input, crane: List[Char] => List[Char]) = {
    val (diag, movesRaw) = input.splitByBlankLine
    val moves = movesRaw.lines.map(_.ints match
      case List(cnt, from, to) => (cnt, from, to))

    val origStacks = diag
      .lines
      .dropRight(1)
      .flatMap(_
        .grouped(4)
        .map(_ (1))
        .zipWithIndex
        .filter(_._1 != ' ')
        .map(x => (x._2 + 1, x._1))
        .toMap
      )
      .groupBy(_._1)
      .view
      .mapValues(_.map(_._2).toList)
      .toMap

    moves.foldLeft(origStacks) {
      case (stacks, (cnt, from, to)) =>
        stacks
          .updated(to, crane(stacks(from).take(cnt)) ++ stacks(to))
          .updated(from, stacks(from).drop(cnt))
    }
      .toList
      .sortBy(_._1)
      .map(_._2.head)
      .mkString
  }

  override def part1(input: Input): Answer = {
    solve(input, _.reverse)
  }

  override def part2(input: Input): Answer = {
    solve(input, identity)
  }
}
