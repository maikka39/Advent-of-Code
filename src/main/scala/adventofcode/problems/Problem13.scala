package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.{Answer, Input, Problem}

import scala.annotation.tailrec
import scala.language.implicitConversions

object Problem13 extends Problem {
  private def simplify(input: Seq[String]): Seq[String] = input
    .filter(_.nonEmpty)
    .map(_.replace("10", "A"))

  @tailrec
  private def compare(left: String, right: String): Boolean = (left.head, right.head) match
    case (a, b) if a == b => compare(left.tail, right.tail)
    case (']', _) => true
    case (_, ']') => false
    case ('[', b) => compare(left.tail, b + "]" + right.tail)
    case (a, '[') => compare(a + "]" + left.tail, right.tail)
    case (a, b) => a < b

  override def part1(input: Input): Answer = {
    simplify(input.lines)
      .grouped(2)
      .zipWithIndex
      .collect {
        case (Seq(left, right), index) if compare(left, right) => index + 1
      }
      .sum
  }

  override def part2(input: Input): Answer = {
    val dividers = Seq("[[2]]", "[[6]]")
    val sorted = (simplify(input.lines) ++ dividers).sortWith(compare)

    dividers.map(sorted.indexOf(_) + 1).product
  }
}
