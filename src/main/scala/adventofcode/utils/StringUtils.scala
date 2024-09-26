package adventofcode.utils

object StringUtils {
  implicit class StringImprovements(s: String) {
    def ints: List[Int] = "\\d+".r.findAllIn(s).map(_.toInt).toList

    def longs: List[Long] = "\\d+".r.findAllIn(s).map(_.toLong).toList

    def shortInts: List[Int] = "\\d".r.findAllIn(s).map(_.toInt).toList

    def signedInts: List[Int] = "-?\\d+".r.findAllIn(s).map(_.toInt).toList

    def isValidInt: Boolean = s.toIntOption.isDefined

    def splitLines: List[String] = s.split('\n').toList

    def grid: List[List[Char]] = s.splitLines.map(_.toList)

    def splitByBlankLines: List[String] = s.split("\n\n").toList

    def splitByBlankLine: (String, String) = {
      val List(a, b) = s.splitByBlankLines
      a -> b
    }
  }
}
