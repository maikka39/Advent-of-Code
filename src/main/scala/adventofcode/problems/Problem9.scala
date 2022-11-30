package adventofcode.problems

import adventofcode.Problem

import scala.collection.mutable.ListBuffer

object Problem9 extends Problem {
  override def part1(input: List[String]): String = {
    val preambleLength = input.head.toInt
    val transmission = input.drop(1).map(_.toLong)

    transmission
      .sliding(preambleLength + 1)
      .map(_.splitAt(preambleLength))
      .map(x => x._1 -> x._2.head)
      .find(x => {
        !x._1
          .combinations(2)
          .map(_.sum)
          .contains(x._2)
      })
      .get
      ._2
      .toString
  }

  override def part2(input: List[String]): String = {
    val invalidNumber = part1(input).toLong

    val numbers = input
      .drop(1)
      .map(_.toLong)

    (0 until numbers.indexOf(invalidNumber))
      .map(i => addsUpToN(numbers.drop(i), invalidNumber))
      .find(_.isDefined)
      .get
      .get
      .toString
  }

  private def addsUpToN(numbers: List[Long], expectedN: Long) = {
    var s = 0L
    val seen = ListBuffer[Long]()
    val end = numbers.find(n => {
      s += n
      seen += n
      s == expectedN
    })
    end.map(_ => seen.min + seen.max)
  }
}

