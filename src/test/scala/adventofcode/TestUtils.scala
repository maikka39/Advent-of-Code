package adventofcode

import scala.io.Source
import adventofcode.utils.StringUtils._

trait TestUtils {
  def getInput(problem: Int, filename: String): String = {
    val source = Source.fromURL(getClass.getResource(s"/input/problem$problem/$filename"))
    source.mkString
  }
}
