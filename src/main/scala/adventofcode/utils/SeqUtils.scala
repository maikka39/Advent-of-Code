package adventofcode.utils

import scala.annotation.targetName
import scala.collection.mutable.ListBuffer

object SeqUtils {
  implicit class SeqImprovements[A](iterable: Seq[A]) {
    def isValidIndex(i: Int): Boolean = i >= 0 && i < iterable.size
  }

  type Pos2d = (Int, Int)

  implicit class Seq2dImprovements[A](grid: Seq[Seq[A]]) {

    import adventofcode.utils.SeqUtils.SeqImprovements

    def isValidIndex(i: Pos2d): Boolean = grid.isValidIndex(i._1) && grid(i._1).isValidIndex(i._2)

    def apply(n: Pos2d): A = grid(n._1)(n._2)

    def locateWhere(f: A => Boolean): Seq[Pos2d] =
      grid.zipWithIndex.flatMap((row, y) => row.zipWithIndex.filter((v, x) => f(v)).map(y -> _._2))

    def locate(x: A): Option[Pos2d] = locateWhere(_ == x).headOption

    def tupleIndices: Seq[Pos2d] = grid.zipWithIndex.flatMap((row, y) => row.indices.map(x => y -> x))

    def zipWithTupleIndex: Seq[Seq[(A, (Int, Int))]] = grid.zipWithIndex.map((row, y) => row.zipWithIndex.map((value, x) => value -> (y -> x)))
  }

  implicit class PosSeqImprovements(positions: Seq[Pos2d]) {
    // https://en.wikipedia.org/wiki/Shoelace_formula
    def area: Double = {
      (positions ++ positions.take(1))
        .sliding(2)
        .map {
          case a :: b :: Nil =>
            a._1 * b._2 - a._2 * b._1
        }
        .sum
        .abs
        / 2.0
    }
  } 
}
