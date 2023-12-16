package adventofcode

import scala.io.Source
import adventofcode.utils.StringUtils._

trait TestUtils {
  def getInput(problem: Int, filename: String): Input = {
    val source = Source.fromURL(getClass.getResource(s"/input/problem$problem/$filename"))
    source.getLines.mkString("\n").toInput
  }
}
