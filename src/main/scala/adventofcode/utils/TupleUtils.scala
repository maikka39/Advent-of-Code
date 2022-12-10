package adventofcode.utils

import scala.annotation.targetName
import scala.collection.mutable.ListBuffer

object TupleUtils {
  implicit class IntTupleImprovements(tuple: (Int, Int)) {
    @targetName("add")
    def +(other: (Int, Int)): (Int, Int) = (tuple._1 + other._1, tuple._2 + other._2)

    @targetName("subtract")
    def -(other: (Int, Int)): (Int, Int) = (tuple._1 - other._1, tuple._2 - other._2)

    @targetName("multiply")
    def *(n: Int): (Int, Int) = (tuple._1 * n, tuple._2 * n)

    def abs: (Int, Int) = (tuple._1.abs, tuple._2.abs)

    def max: Int = if (tuple._2 > tuple._1) tuple._2 else tuple._1
    
    def sign: (Int, Int) = (tuple._1.sign, tuple._2.sign)
  }
}