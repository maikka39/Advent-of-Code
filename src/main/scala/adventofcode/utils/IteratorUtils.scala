package adventofcode.utils

import scala.util.control.Breaks.*

object IteratorUtils {
  implicit class IteratorImprovements[A](iterator: Iterator[A]) {
    def countTo(p: A => Boolean): Int = {
      var seen = 0
      breakable {
        for (h <- iterator) {
          seen += 1
          if (p(h)) break
        }
      }
      seen
    }
  }
}
