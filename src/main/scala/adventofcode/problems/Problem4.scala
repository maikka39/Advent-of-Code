package adventofcode.problems

import adventofcode.Problem

import scala.util.{Failure, Success, Try}

object Problem4 extends Problem {
  private def parsePassports(input: List[String]): List[List[(String, String)]] = {
    input
      .mkString("\n")
      .split("\n\n")
      .map(_
        .replace('\n', ' ')
        .split(' ')
        .map(value => value.splitAt(value.indexOf(':')))
        .map(value => value._1 -> value._2.drop(1))
        .toList
      )
      .toList
  }

  override def part1(input: List[String]): String = {
    val passports = parsePassports(input)

    passports
      .count(_.count(_._1 != "cid") == 7)
      .toString
  }

  override def part2(input: List[String]): String = {
    val passports = parsePassports(input)

    passports.count(_
      .count(_ match
        case ("byr", value) => {
          val year = value.toInt
          year >= 1920 && year <= 2002
        }
        case ("iyr", value) => {
          val year = value.toInt
          year >= 2010 && year <= 2020
        }
        case ("eyr", value) => {
          val year = value.toInt
          year >= 2020 && year <= 2030
        }
        case ("hgt", value) => {
          val height = Try(value.dropRight(2).toInt)
          val unit = value.takeRight(2)

          height.map(height =>
            unit match
              case "cm" => height >= 150 && height <= 193
              case "in" => height >= 59 && height <= 76
              case _ => false
          ) match
            case Failure(_) => false
            case Success(value) => value
        }
        case ("hcl", value) => {
          value.head == '#' && value.drop(1).matches("([0-9]|[a-f]){6}")
        }
        case ("ecl", value) => {
          ("amb" :: "blu" :: "brn" :: "gry" :: "grn" :: "hzl" :: "oth" :: Nil).contains(value)
        }
        case ("pid", value) => {
          value.matches("[0-9]{9}")
        }
        case ("cid", _) => {
          false
        }
        case _ => {
          false
        }
      ) == 7)
      .toString
  }
}

