package adventofcode

import scala.io.Source

trait TestUtils {
  def getInput(problem: Int, filename: String): List[String] = {
    val source = Source.fromURL(getClass.getResource(s"/input/problem$problem/$filename"))
    source.getLines.toList
  }
}
