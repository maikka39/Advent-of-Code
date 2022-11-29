package adventofcode.problems

import adventofcode.Problem

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object Problem8 extends Problem {
  private def extractValues(instructionLine: String) = {
    val (instruction, argument) = instructionLine.splitAt(instructionLine.indexOf(' '))
    (instruction, argument.strip().toInt)
  }

  @tailrec
  private def runInstructions(instructions: List[(String, Int)], current: Int = 0, accumulator: Int = 0, handledInstructions: List[Int] = List()): (Boolean, Int) = {
    if (current >= instructions.size)
      true -> accumulator
    else if (handledInstructions.contains(current))
      false -> accumulator
    else {
      val line = instructions(current)
      val (new_current, new_accumulator) = runInstruction(line, current, accumulator)
      runInstructions(instructions, new_current, new_accumulator, handledInstructions.appended(current))
    }
  }

  private def runInstruction(instructionLine: (String, Int), current: Int, accumulator: Int) = {
    val (instruction, argument) = instructionLine

    instruction match
      case "nop" => (current + 1, accumulator)
      case "acc" => (current + 1, accumulator + argument)
      case "jmp" => (current + argument, accumulator)
  }

  override def part1(input: List[String]): String = {
    val instructions = input.map(extractValues)

    runInstructions(instructions)
      ._2
      .toString
  }

  override def part2(input: List[String]): String = {
    val instructions = input.map(extractValues)
    
    val switch = Map(
      "nop" -> "jmp",
      "jmp" -> "nop",
    )

    instructions
      .zipWithIndex
      .filter(v => switch.contains(v._1._1))
      .map(switch_inst =>
        runInstructions(
          instructions
            .zipWithIndex
            .map(oi => if (oi._2 == switch_inst._2) (switch(switch_inst._1._1), switch_inst._1._2) else oi._1)
        )
      )
      .find(_._1 == true)
      .get
      ._2
      .toString
  }
}

