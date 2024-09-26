package adventofcode.days

import adventofcode.utils.AnswerUtils.given
import adventofcode.{Answer, Day}
import adventofcode.utils.StringUtils.StringImprovements

import scala.annotation.tailrec
import scala.language.implicitConversions
import scala.math.pow

object Day4 extends Day {
  private case class Card(id: Int, winningNumbers: List[Int], myNumbers: List[Int])

  private def toCards(input: String): List[Card] = {
    input
      .splitLines
      .map {
        case s"Card $id: $winningNumbers | $myNumbers" => Card(id.strip().toInt, winningNumbers.ints, myNumbers.ints)
      }
  }

  override def part1(input: String): Answer = {
    toCards(input)
      .map { card =>
        card.myNumbers.count(card.winningNumbers.contains(_))
      }
      .map(c => pow(2, c - 1).toInt)
      .sum
  }

  override def part2(input: String): Answer = {
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
