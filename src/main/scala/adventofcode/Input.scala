package adventofcode

import adventofcode.utils.StringUtils._

class Input(private val rawInput: String) {
  def string: String = rawInput
  def lines: List[String] = string.split('\n').toList

  def splitByBlankLines: List[String] = string.split("\n\n").toList
  def splitByBlankLine: (Input, Input) = {
    val List(a, b) = splitByBlankLines.map(_.toInput)
    a -> b
  }

  def toSubInputs: List[Input] = splitByBlankLines.map(_.toInput)
}
