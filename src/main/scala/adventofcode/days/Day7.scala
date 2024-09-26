package adventofcode.days

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.StringUtils.given
import adventofcode.{Answer, Day}

object Day7 extends Day {
  private def toScore(char: Char): Int = {
    char match {
      case 'A' => 14
      case 'K' => 13
      case 'Q' => 12
      case 'J' => 11
      case 'T' => 10
      case n => n.toInt - '0'
    }
  }

  private def handScore(hand: List[Int], useJoker: Boolean): Int = {
    val usableHand = if (useJoker) hand.filter(_ != 11) else hand

    val counts = usableHand
      .groupBy(v => v)
      .values
      .map(_.size)
      .toList
      .sortBy(-_)

    counts.headOption.getOrElse(0) + hand.count(useJoker && _ == 11) match
      case 5 => 6
      case 4 => 5
      case 3 if counts(1) == 2 => 4
      case 3 => 3
      case 2 if counts(1) == 2 => 2
      case 2 => 1
      case 1 => 0
  }

  private def solve(input: String, sorting: List[Int] => String): Int = {
    input
      .splitLines
      .map(line => line.splitAt(line.indexOf(' ')))
      .map { case (hand, bid) =>
        sorting(hand.toList.map(toScore)) -> bid.strip().toInt
      }
      .sorted
      .map(_._2)
      .zipWithIndex
      .map { case (bid, index) => bid * (index + 1) }
      .sum
  }

  override def part1(input: String): Answer = {
    solve(input, hand => handScore(hand, false).toChar + hand.map(_.toChar).mkString)
  }

  override def part2(input: String): Answer = {
    solve(input, hand => handScore(hand, true).toChar + hand.map(v => if (v == 11) 1 else v).map(_.toChar).mkString)
  }
}
