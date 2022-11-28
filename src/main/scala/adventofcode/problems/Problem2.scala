package adventofcode.problems

import adventofcode.Problem

object Problem2 extends Problem {
  private def parseLine(line: String) = {
    val l = line.substring(0, line.indexOf('-')).toInt
    val h = line.substring(line.indexOf('-') + 1, line.indexOf(' ')).toInt
    val c = line.substring(line.indexOf(' ') + 1, line.indexOf(':')).charAt(0)
    val s = line.substring(line.indexOf(':') + 2)
    (l, h, c, s)
  }
  
  override def part1(input: List[String]): String = {
    input
      .count(line => {
        val (l: Int, h: Int, c: Char, s: String) = parseLine(line)

        val count = s.count(_ == c)

        l <= count && count <= h
      })
      .toString
  }

  override def part2(input: List[String]): String = {
    input
      .count(line => {
        val (l: Int, h: Int, c: Char, s: String) = parseLine(line)

        (s.charAt(l-1) == c) != (s.charAt(h-1) == c)
      })
      .toString
  }
}

