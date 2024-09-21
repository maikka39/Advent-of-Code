package adventofcode.utils

import scala.annotation.tailrec
import scala.math.Integral.Implicits.infixIntegralOps

object MathUtils {
  @tailrec
  def gcd[N](a: N, b: N)(using n: Integral[N]): N = if a == n.zero then b else gcd(b % a, a)

  def lcm[N: Integral](iter: IterableOnce[N]): N = iter.iterator.reduceLeft((a, b) => (a * b) / gcd(a, b))
}
