package adventofcode.utils

import scala.collection.mutable

object FunctionUtils {
  def memoize[A, B](f: A => B): A => B = {
    val memo = mutable.Map[A, B]()
    arg => memo.getOrElseUpdate(arg, f(arg))
  }
}
