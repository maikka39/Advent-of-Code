package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.{Answer, Input, Problem}
import adventofcode.utils.StringUtils.StringImprovements

import scala.annotation.tailrec
import scala.language.implicitConversions
import scala.math.pow

object Problem4 extends Problem {
  private case class Card(id: Int, winningNumbers: List[Int], myNumbers: List[Int])

  private def toCards(input: Input): List[Card] = {
    input
      .lines
      .map {
        case s"Card $id: $winningNumbers | $myNumbers" => Card(id.strip().toInt, winningNumbers.ints, myNumbers.ints)
      }
  }

  override def part1(input: Input): Answer = {
    toCards(input)
      .map { card =>
        card.myNumbers.count(card.winningNumbers.contains(_))
      }
      .map(c => pow(2, c - 1).toInt)
      .sum
  }

  override def part2(input: Input): Answer = {
    val cards = toCards(input)
    val cardScores = cards.map { card =>
      card.id -> card.myNumbers.count(card.winningNumbers.contains(_))
    }.toMap

    val totalScores = cards.reverse.foldLeft(Map.empty[Int, Int]) { (a, b) =>
      val totalCardScore = 1 + (b.id + 1 to b.id + cardScores(b.id)).flatMap(a.get).sum
      a + (b.id -> totalCardScore)
    }

    totalScores.values.sum
  }
}
