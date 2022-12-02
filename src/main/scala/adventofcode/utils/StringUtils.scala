package adventofcode.utils

import adventofcode.Input

object StringUtils {
  implicit class StringImprovements(s: String) {
    def toInput: Input = Input(s)
  }
}
