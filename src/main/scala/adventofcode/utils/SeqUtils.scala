package adventofcode.utils

import scala.annotation.targetName
import scala.collection.mutable.ListBuffer

object SeqUtils {
  implicit class SeqImprovements[A](iterable: Seq[A]) {
    def isValidIndex(i: Int): Boolean = i >= 0 && i < iterable.size
  }
}
