package adventofcode

import scala.io.Source
import adventofcode.utils.StringUtils._

trait TestUtils {
  def getInput(day: Int, filename: String): String = {
    val source = Source.fromURL(getClass.getResource(s"/input/day$day/$filename"))
    source.mkString
  }
}
