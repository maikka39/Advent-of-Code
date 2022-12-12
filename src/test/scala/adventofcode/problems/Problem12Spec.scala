package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem12Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem12.part1(getInput(12, "sample.txt")).answer shouldBe 31
    }

    "solve the actual input" in {
      Problem12.part1(getInput(12, "input.txt")).answer shouldBe 490
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem12.part2(getInput(12, "sample.txt")).answer shouldBe 29
    }

    "solve the actual input" in {
      Problem12.part2(getInput(12, "input.txt")).answer shouldBe 488
    }
  }
}
