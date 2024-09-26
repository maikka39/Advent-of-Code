package adventofcode.days

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Day7Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Day7.part1(getInput(7, "sample.txt")).answer shouldBe 6440
    }

    "solve the actual input" in {
      Day7.part1(getInput(7, "input.txt")).answer shouldBe 251106089
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Day7.part2(getInput(7, "sample.txt")).answer shouldBe 5905
    }

    "solve the actual input" in {
      Day7.part2(getInput(7, "input.txt")).answer shouldBe 249620106
    }
  }
}
