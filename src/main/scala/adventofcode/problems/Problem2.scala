package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.{Answer, Input, Problem}

import scala.language.implicitConversions

object Problem2 extends Problem {
  private def parseGame(game: String): (Int, Array[Map[String, Int]]) = {
    game match
      case s"Game $gameId: $bagReveals" => (gameId.toInt, bagReveals.split("; ").map(_.split(", ").map {
        case s"$count $color" => (color, count.toInt)
      }.toMap))
  }

  override def part1(input: Input): Answer = {
    val bag = Map(("red", 12), ("green", 13), ("blue", 14))

    input
      .lines
      .map(parseGame)
      .filterNot(game => game._2.exists(set => set.exists(part => part._2 > bag(part._1))))
      .map(_._1)
      .sum
  }

  override def part2(input: Input): Answer = {
    input
      .lines
      .map(parseGame(_)._2)
      .map(sets => sets.fold(Map.empty[String, Int]) { (a, b) =>
        (a ++ b).map(e =>
          (e._1, math.max(e._2, a.getOrElse(e._1, 0)))
        )
      })
      .map(_.values.product)
      .sum
  }
}
