package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.TupleUtils.*
import adventofcode.{Answer, Input, Problem}

import scala.language.implicitConversions

object Problem9 extends Problem {
  private def parseActions(input: Input) = {
    input
      .lines
      .map(_.splitAt(1))
      .map { line =>
        val direction = line._1 match
          case "U" => (0, 1)
          case "D" => (0, -1)
          case "R" => (1, 0)
          case "L" => (-1, 0)

        val amount = line._2.strip().toInt

        direction -> amount
      }
  }

  private def getTrailPosCount(actions: List[((Int, Int), Int)], knotCount: Int) = {
    def snap(t: (Int, Int)) = if (t.abs.max > 1) t - t.sign else t

    actions.foldLeft((List.fill(knotCount)((0, 0)), Set((0, 0)))) { (ks, action) =>
      val (direction, amount) = action

      (1 to amount).foldLeft(ks) { (ks, _) =>
        val (knots, seen) = ks

        val newKnots = knots.indices.drop(1).foldLeft(knots.updated(0, knots.head + direction)) { (knots, i) =>
          knots.updated(i, knots(i - 1) + snap(knots(i) - knots(i - 1)))
        }

        newKnots -> (seen + newKnots.last)
      }
    }._2.size
  }

  override def part1(input: Input): Answer = {
    val actions = parseActions(input)
    getTrailPosCount(actions, 2)
  }

  override def part2(input: Input): Answer = {
    val actions = parseActions(input)
    getTrailPosCount(actions, 10)
  }
}
