package adventofcode.problems

import adventofcode.Problem

import scala.collection.MapView

object Problem7 extends Problem {
  private def parseLine(line: String) = {
    val (parent, content_with_prefix) = line.splitAt(line.indexOf(" contain "))
    val content = content_with_prefix
      .drop(9)
      .split(',')
      .map(_.strip())
      .map(content => {
        val (count, item) = content.splitAt(content.indexOf(' '))
        if (count == "no")
          0 -> ""
        else
          count.toInt -> (item.strip().stripSuffix(".").stripSuffix("s") + "s")
      })
      .filter(_._1 != 0)
      .toList
    parent -> content
  }

  private def findParents(mappings: MapView[String, List[String]], target: String): Set[String] = {
    val parents = mappings
      .filter(tuple => {
        val (_, children) = tuple
        children.contains(target)
      })
      .keys
      .toList

    parents
      .flatMap(parent => findParents(mappings, parent) + parent)
      .toSet
  }

  private def findChildCount(mappings: MapView[String, List[(Int, String)]], target: String): Int = {
    mappings(target)
      .map(v => v._1 + v._1 * findChildCount(mappings, v._2))
      .sum
  }

  override def part1(input: List[String]): String = {
    val mappings = input
      .map(parseLine)
      .toMap
      .view
      .mapValues(_.map(_._2))

    findParents(mappings, "shiny gold bags")
      .size
      .toString
  }

  override def part2(input: List[String]): String = {
    val mappings = input
      .map(parseLine)
      .toMap
      .view

    findChildCount(mappings, "shiny gold bags")
      .toString
  }
}

