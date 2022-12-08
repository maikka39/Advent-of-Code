package adventofcode.utils

import scala.annotation.targetName
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.*

object IteratorUtils {
  implicit class IteratorImprovements[A](iterable: Iterator[A]) {
    def countTo(p: A => Boolean): Int = {
      var seen = 0
      breakable {
        for (h <- iterable) {
          seen += 1
          if (p(h)) break
        }
      }
      seen
    }
  }
}
