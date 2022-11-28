package adventofcode

import adventofcode.FindPuzzle.findProblemReference

import scala.io.Source.stdin
import scala.util.{Failure, Success, Try}

@main def run(args: String*): Unit = {
  val problemNumber = Try(args(0).toInt)
  val problemPart = Try(args(1).toInt)
  val problem = problemNumber.flatMap(findProblemReference)
  val solution = problemPart
    .flatMap(part => problem.map(_ -> part))
    .map(d =>
        d._2 match
        case 1 => d._1.part1(stdin.getLines.toList)
        case 2 => d._1.part2(stdin.getLines.toList)
    )

  solution match {
    case Failure(exception) => println(s"Something went wrong with opening the puzzle: \n$exception")
    case Success(value) => println(value)
  }
}