package adventofcode.utils

import scala.annotation.targetName
import scala.collection.mutable.ListBuffer

object SeqUtils {
  implicit class SeqImprovements[A](iterable: Seq[A]) {
    def isValidIndex(i: Int): Boolean = i >= 0 && i < iterable.size
  }

  implicit class Seq2dImprovements[A](grid: Seq[Seq[A]]) {
    def isValidIndex(i: Int): Boolean = i >= 0 && i < grid.size

    def isValidIndex(i: (Int, Int)): Boolean = grid.isValidIndex(i._1) && grid(i._1).isValidIndex(i._2)

    def apply(n: (Int, Int)): A = grid(n._1)(n._2)

    def locate(x: A): (Int, Int) = {
      val row = grid.indexWhere(_.contains(x))
      row -> grid(row).indexWhere(_ == x)
    }
  }
}
