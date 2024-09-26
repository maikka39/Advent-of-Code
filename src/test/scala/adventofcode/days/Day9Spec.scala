package adventofcode.days

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Day9Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Day9.part1(getInput(9, "sample.txt")).answer shouldBe 114
    }

    "solve the actual input" in {
      Day9.part1(getInput(9, "input.txt")).answer shouldBe 1681758908
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Day9.part2(getInput(9, "sample.txt")).answer shouldBe 2
    }

    "solve the actual input" in {
      Day9.part2(getInput(9, "input.txt")).answer shouldBe 803
    }
  }
}
