package adventofcode.problems

import adventofcode.utils.AnswerUtils.given
import adventofcode.{Answer, Input, Problem}

import scala.language.implicitConversions

object Problem11 extends Problem {
  private case class Monkey(items: Seq[Long], operation: Long => Long, monkeyToThrowTo: Long => Int, testValue: Int, inspectionCount: Long)

  private def parseMonkeys(input: Input) = {
    input
      .toSubInputs
      .map { par =>
        val List(_, startingItems, operation, test, trueTarget, falseTarget) = par.lines

        val items = startingItems match
          case s"  Starting items: $items" => items.split(", ").map(_.toLong)

        val operationCalculation = operation match
          case s"  Operation: new = $value" => value

        val testDivisibleByValue = test match
          case s"  Test: divisible by $value" => value.toInt

        val targetA = trueTarget match
          case s"    If true: throw to monkey $targetId" => targetId.toInt

        val targetB = falseTarget match
          case s"    If false: throw to monkey $targetId" => targetId.toInt

        Monkey(
          items,
          old => operationCalculation.replaceAll("old", old.toString) match
            case s"$a + $b" => a.toLong + b.toLong
            case s"$a * $b" => a.toLong * b.toLong
          ,
          value => if (value % testDivisibleByValue == 0) targetA else targetB,
          testDivisibleByValue,
          0,
        )
      }
  }

  private def monkeyBusinessLevel(initialMonkeys: Seq[Monkey], rounds: Int, newItemCalculation: Long => Long) = {
    (1 to rounds)
      .foldLeft(initialMonkeys) { (roundMonkeys, _) =>
        roundMonkeys.indices.foldLeft(roundMonkeys) { (monkeyRoundMonkeys, roundMonkeyId) =>
          val monkey = monkeyRoundMonkeys(roundMonkeyId)

          monkey.items.foldLeft(monkeyRoundMonkeys) { (monkeys, item) =>
            val newItem = newItemCalculation(monkey.operation(item))
            val receivingMonkeyId = monkey.monkeyToThrowTo(newItem)

            val receivingMonkey = monkeys(receivingMonkeyId)

            monkeys.updated(receivingMonkeyId, receivingMonkey.copy(items = receivingMonkey.items.appended(newItem)))
          }
            .updated(roundMonkeyId, monkey.copy(items = Seq.empty, inspectionCount = monkey.inspectionCount + monkey.items.size))
        }
      }
      .map(_.inspectionCount)
      .sorted
      .takeRight(2)
      .product
  }

  override def part1(input: Input): Answer = {
    val initialMonkeys = parseMonkeys(input)

    monkeyBusinessLevel(initialMonkeys, 20, _ / 3)
  }

  override def part2(input: Input): Answer = {
    val initialMonkeys = parseMonkeys(input)
    val modulus = initialMonkeys.map(_.testValue).product

    monkeyBusinessLevel(initialMonkeys, 10000, _ % modulus)
  }
}
