package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem2Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem2.part1(getInput(2, "sample.txt")).answer shouldBe 8
    }

    "solve the actual input" in {
      Problem2.part1(getInput(2, "input.txt")).answer shouldBe 2563
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem2.part2(getInput(2, "sample.txt")).answer shouldBe 2286
    }

    "solve the actual input" in {
      Problem2.part2(getInput(2, "input.txt")).answer shouldBe 70768
    }
  }
}
