package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.StringUtils.given
import adventofcode.utils.IteratorUtils.given
import adventofcode.utils.MathUtils.lcm
import adventofcode.{Answer, Problem}

import scala.language.implicitConversions

object Problem8 extends Problem {
  private def path(network: Map[String, (String, String)], turns: Iterable[Boolean], start: String): Iterator[String] = {
    Iterator.continually(turns).flatten.scanLeft(start) { (name, left) =>
      if left then network(name)._1 else network(name)._2
    }
  }

  private def parse(input: String) = {
    val (turns, mapping) = input.splitByBlankLine

    val network = mapping
      .splitLines
      .map { case s"$name = ($left, $right)" => name -> (left, right) }
      .toMap

    (network, turns.map(_ == 'L'))
  }

  override def part1(input: String): Answer = {
    val (network, turns) = parse(input)

    path(network, turns, "AAA").indexOf("ZZZ")
  }

  override def part2(input: String): Answer = {
    val (network, turns) = parse(input)

    val startNodes = network.keys.filter(_.endsWith("A"))
    val steps = startNodes.map(path(network, turns, _).indexWhere(_.endsWith("Z")))
    lcm(steps.map(_.toLong)).toLong
  }
}
