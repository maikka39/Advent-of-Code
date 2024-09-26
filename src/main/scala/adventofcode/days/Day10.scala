package adventofcode.days

import adventofcode.utils.AnswerUtils.given
import adventofcode.utils.StringUtils.given
import adventofcode.utils.SeqUtils.{Pos2d, given}
import adventofcode.utils.TupleUtils.given
import adventofcode.{Answer, Day}

import scala.annotation.tailrec

object Day10 extends Day {
  private def parseMap(input: String) = {
    val origGrid = input.grid

    def charToDirection(value: Char): Set[Pos2d] = {
      value match
        case '|' => Set((-1, 0), (1, 0))
        case '-' => Set((0, -1), (0, 1))
        case 'L' => Set((-1, 0), (0, 1))
        case 'J' => Set((-1, 0), (0, -1))
        case '7' => Set((1, 0), (0, -1))
        case 'F' => Set((1, 0), (0, 1))
        case '.' => Set.empty
        case 'S' => Set.empty
    }

    val mapped = origGrid
      .zipWithTupleIndex
      .map(_
        .map((value, pos) => charToDirection(value)
          .map(pos + _)
          .filter(origGrid.isValidIndex)
        )
      )

    val start = origGrid.locate('S').get
    val connectionsToStart = mapped.locateWhere(_.contains(start))

    val grid = mapped
      .zipWithTupleIndex
      .map(_
        .map((connections, pos) => if (pos == start) connectionsToStart.take(1) else connections)
      )

    (grid, start)
  }

  override def part1(input: String): Answer = {
    val (grid, start) = parseMap(input)

    @tailrec
    def loopSize(current: Pos2d, previous: Pos2d, depth: Int): Int = {
      if (current == start && depth > 0)
        depth
      else
        loopSize(grid(current).find(_ != previous).get, current, depth + 1)
    }

    loopSize(start, start, 0) / 2
  }

  override def part2(input: String): Answer = {
    val (grid, start) = parseMap(input)

    @tailrec
    def findLoop(current: Pos2d, previous: Pos2d, seen: Seq[Pos2d]): Seq[Pos2d] = {
      if (current == start && previous != start)
        seen
      else
        findLoop(grid(current).find(_ != previous).get, current, seen ++ Seq(current))
    }

    val loopNodes = findLoop(start, start, Seq.empty)

    // https://en.wikipedia.org/wiki/Pick%27s_theorem
    loopNodes.area.toInt + 1 - loopNodes.size / 2
  }
}
