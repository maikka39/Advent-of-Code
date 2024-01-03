package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.{Answer, Input, Problem}
import adventofcode.utils.StringUtils.StringImprovements

import scala.annotation.tailrec
import scala.language.implicitConversions

object Problem5 extends Problem {
  private case class Mapping(source: Long, dest: Long, length: Long)

  private def getInputMappings(b: Input) = {
    val s"$sourceName-to-$destName map:" = b.lines.head: @unchecked

    val mappings = b.lines.tail.map { line =>
      val dest :: source :: length :: Nil = line.longs: @unchecked
      Mapping(source, dest, length)
    }

    (sourceName, destName, mappings)
  }

  override def part1(input: Input): Answer = {
    val subInputs = input.toSubInputs
    val seeds = subInputs.head.string.longs
    val mappings = {
      subInputs.tail.foldLeft(Map.empty[String, (String, Long => Long)]) { (a, b) =>
        val (sourceName, destName, mapping) = getInputMappings(b)

        val x = { (n: Long) =>
          mapping.find(m => n >= m.source && n < (m.source + m.length)).map(m => n - m.source + m.dest).getOrElse(n)
        }

        a + (sourceName -> (destName, x))
      }
    }

    @tailrec def mapToLocation(currentType: String, value: Long): Long = {
      if (currentType == "location") value else mapToLocation(mappings(currentType)._1, mappings(currentType)._2(value))
    }

    seeds
      .map(value => mapToLocation("seed", value))
      .min
  }

  override def part2(input: Input): Answer = {
    val subInputs = input.toSubInputs
    val seeds = subInputs.head.string.longs
    val mappings = {
      subInputs.tail.foldLeft(Map.empty[String, (String, Long => Long)]) { (a, b) =>
        val (sourceName, destName, mapping) = getInputMappings(b)

        val x = { (n: Long) =>
          mapping.find(m => n >= m.dest && n < (m.dest + m.length)).map(m => n - m.dest + m.source).getOrElse(n)
        }

        a + (destName -> (sourceName, x))
      }
    }

    @tailrec def mapToSeed(currentType: String, value: Long): Long = {
      if (currentType == "seed") value else mapToSeed(mappings(currentType)._1, mappings(currentType)._2(value))
    }

    def isValidSeed(seed: Long) = {
      seeds
        .sliding(2, 2)
        .exists(r => seed >= r.head && seed < (r.head + r.last))
    }

    LazyList.from(0).find(n => isValidSeed(mapToSeed("location", n))).get
  }
}
