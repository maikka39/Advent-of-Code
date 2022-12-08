package adventofcode.utils

import scala.annotation.targetName
import scala.collection.mutable.ListBuffer

object TupleUtils {
  implicit class IntTupleImprovements(tuple: (Int, Int)) {
    @targetName("add")
    def +(other: (Int, Int)): (Int, Int) = (tuple._1 + other._1, tuple._2 + other._2)
  }
}
