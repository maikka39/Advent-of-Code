package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem4Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem4.part1(getInput(4, "sample.txt")).answer shouldBe 13
    }

    "solve the actual input" in {
      Problem4.part1(getInput(4, "input.txt")).answer shouldBe 26346
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem4.part2(getInput(4, "sample.txt")).answer shouldBe 30
    }

    "solve the actual input" in {
      Problem4.part2(getInput(4, "input.txt")).answer shouldBe 8467762
    }
  }
}
