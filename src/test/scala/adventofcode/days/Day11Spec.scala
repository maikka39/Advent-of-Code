package adventofcode.days

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Day11Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Day11.part1(getInput(11, "sample.txt")).answer shouldBe 374
    }

    "solve the actual input" in {
      Day11.part1(getInput(11, "input.txt")).answer shouldBe 9957702
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Day11.part2(getInput(11, "sample.txt")).answer shouldBe 82000210
    }

    "solve the actual input" in {
      Day11.part2(getInput(11, "input.txt")).answer shouldBe 512240933238L
    }
  }
}
