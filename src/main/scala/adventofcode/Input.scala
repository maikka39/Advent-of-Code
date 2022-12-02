package adventofcode

import adventofcode.utils.StringUtils._

class Input(private val rawInput: String) {
  override def toString: String = rawInput

  def lines: List[String] = rawInput.split('\n').toList

  def toSubInputs: List[Input] = rawInput.split("\n\n").toList.map(_.toInput)
}
