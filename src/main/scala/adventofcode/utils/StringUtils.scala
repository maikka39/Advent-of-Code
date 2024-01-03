package adventofcode.utils

import adventofcode.Input

object StringUtils {
  implicit class StringImprovements(s: String) {
    def toInput: Input = Input(s)
    def ints: List[Int] = "\\d+".r.findAllIn(s).map(_.toInt).toList
    def longs: List[Long] = "\\d+".r.findAllIn(s).map(_.toLong).toList
    def shortInts: List[Int] = "\\d".r.findAllIn(s).map(_.toInt).toList
    def signedInts: List[Int] = "-?\\d+".r.findAllIn(s).map(_.toInt).toList
    def isValidInt: Boolean = s.toIntOption.isDefined
  }
}
