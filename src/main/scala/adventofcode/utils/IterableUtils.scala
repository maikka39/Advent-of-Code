package adventofcode.utils

import scala.annotation.targetName
import scala.collection.mutable.ListBuffer

object IterableUtils {
  implicit class IterableImprovements[A](iterable: Iterable[A]) {
    @targetName("plus")
    def +(elem: A): Iterable[A] = iterable ++ Iterator(elem)
  }
}
