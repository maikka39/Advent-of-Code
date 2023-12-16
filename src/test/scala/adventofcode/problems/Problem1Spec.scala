package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Problem1Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem1.part1(getInput(1, "sample.txt")).answer shouldBe 142
    }

    "solve the actual input" in {
      Problem1.part1(getInput(1, "input.txt")).answer shouldBe 55172
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem1.part2(getInput(1, "sample2.txt")).answer shouldBe 281
    }

    "solve the actual input" in {
      Problem1.part2(getInput(1, "input.txt")).answer shouldBe 54925
    }
  }
}
