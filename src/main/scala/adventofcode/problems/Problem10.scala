package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.{Answer, Input, Problem}

import scala.language.implicitConversions

object Problem10 extends Problem {
  private def extractValues(input: Input) = {
    input
      .lines
      .map(_.split(' '))
      .flatMap {
        case Array("noop") => 0 :: Nil
        case Array("addx", v) => 0 :: v.toInt :: Nil
      }
      .scan(1)(_ + _)
  }

  override def part1(input: Input): Answer = {
    val values = extractValues(input)

    (20 to 220 by 40).map(x => values(x - 1) * x).sum
  }

  override def part2(input: Input): Answer = {
    val letters = extractValues(input)
      .grouped(40)
      .map(_
        .zipWithIndex
        .map(x => if ((x._1 - x._2).abs <= 1) "#" else " ")
        .mkString
      )
      .mkString("\n")

    for (line <- letters.split('\n')) {
      println(line)
    }

    letters
  }
}
