package adventofcode.utils

import scala.annotation.targetName

object NumberUtils {
  implicit class IntUtils(n: Int) {
    @targetName("floorMod")
    def %%(b: Int): Int = Math.floorMod(n, b)

    def concat(b: Int): Int = (n.toString + b.toString).toInt
  }

  implicit class LongUtils(n: Long) {
    @targetName("floorMod")
    def %%(b: Long): Long = Math.floorMod(n, b)

    @targetName("floorMod")
    def %%(b: Int): Long = Math.floorMod(n, b)
  }
}
