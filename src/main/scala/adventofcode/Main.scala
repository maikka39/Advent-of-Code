package adventofcode

import adventofcode.utils.FindPuzzle.findDayReference
import adventofcode.utils.StringUtils._

import scala.io.Source.stdin
import scala.util.{Failure, Success, Try}

@main def run(args: String*): Unit = {
  println(s"Args: $args")
  val dayNumber = Try(args(0).toInt)
  val dayPart = Try(args(1).toInt)
  val day = dayNumber.flatMap(findDayReference)
  val solution = dayPart
    .flatMap(part => day.map(_ -> part))
    .map((day, part) =>
      val input = stdin.getLines.mkString("\n")
      part match
        case 1 => day.part1(input)
        case 2 => day.part2(input)
    )

  solution match {
    case Failure(exception) => println(s"Something went wrong with opening the puzzle:\n$exception")
    case Success(value) => println(value)
  }
}