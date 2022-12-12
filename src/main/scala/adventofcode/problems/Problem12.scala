package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.SeqUtils.*
import adventofcode.utils.TupleUtils.*
import adventofcode.{Answer, Input, Problem}

import scala.annotation.tailrec
import scala.language.implicitConversions

object Problem12 extends Problem {
  private def parseGrid(input: Input) = {
    val rawGrid = input.lines.map(_.toList)

    val start = rawGrid.locate('S')
    val end = rawGrid.locate('E')

    val grid = rawGrid.map(_.map {
      case 'S' => 'a'
      case 'E' => 'z'
      case c => c
    }.map(_ - 'a'))

    (grid, start, end)
  }

  private def shortestPath(grid: List[List[Int]], start: (Int, Int), end: ((Int, Int)) => Boolean) = {
    @tailrec
    def loop(batch: Set[(Int, Int)], seen: Set[(Int, Int)], dist: Int): Option[Int] = {
      if (batch.isEmpty) {
        None
      } else {
        val nextBatch = for {
          pos <- batch
          neighbor <- pos.neighbors(grid).filter(grid(pos) - grid(_) <= 1)
          if !seen.contains(neighbor)
        } yield neighbor

        if (nextBatch.exists(end(_))) {
          Some(dist + 1)
        } else {
          loop(nextBatch, seen ++ nextBatch, dist + 1)
        }
      }
    }

    loop(Set(start), Set(start), 0).get
  }

  override def part1(input: Input): Answer = {
    val (grid, start, end) = parseGrid(input)

    shortestPath(grid, end, _ == start)
  }

  override def part2(input: Input): Answer = {
    val (grid, _, end) = parseGrid(input)

    shortestPath(grid, end, grid(_) == 0)
  }
}
