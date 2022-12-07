package adventofcode.utils

import scala.annotation.targetName
import scala.collection.mutable.ListBuffer

object IterableUtils {
  implicit class IterableImprovements[A](iterable: Iterable[A]) {
    def slidingStart: Seq[Iterable[A]] = (1 to iterable.size).map(iterable.take)
  }

  implicit class NumericIterableImprovements[A: Numeric](iterable: Iterable[A]) {
    def accumulate: Iterable[A] = {
      iterable
        .slidingStart
        .map(_.sum)
    }
  }

  implicit class StringIterableImprovements(iterable: Iterable[String]) {
    def accumulate: Iterable[String] = accumulate("")

    def accumulate(separator: String): Iterable[String] = {
      iterable
        .slidingStart
        .map(_.reduce(_ + separator + _))
    }
  }
}
