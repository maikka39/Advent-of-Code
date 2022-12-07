package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.IterableUtils.*
import adventofcode.{Answer, Input, Problem}

import scala.language.implicitConversions

object Problem7 extends Problem {
  private def calculateFolderSizes(input: Input) = {
    input
      .lines
      .foldLeft((List.empty[String], Map.empty[String, Int])) { (pathAndSize, line) =>
        val (currentPath, sizes) = pathAndSize
        line match
          case s"$$ $command" => command match
            case s"ls" => pathAndSize
            case s"cd $param" => param match
              case ".." => currentPath.dropRight(1) -> sizes
              case "/" => currentPath.empty -> sizes
              case folder => currentPath.appended(folder) -> sizes
          case s"dir $_" => pathAndSize
          case s"$size $_" => currentPath -> currentPath.prepended("").accumulate("/").foldLeft(sizes)((newSizes, path) => newSizes.updated(path, newSizes.getOrElse(path, 0) + size.toInt))
      }
      ._2
  }

  override def part1(input: Input): Answer = {
    calculateFolderSizes(input)
      .removed("")
      .values
      .filter(_ <= 100000)
      .sum
  }

  override def part2(input: Input): Answer = {
    val needed = 70000000 - 30000000
    val sizes = calculateFolderSizes(input)

    sizes
      .values
      .filter(_ >= sizes("") - needed)
      .min
  }
}
