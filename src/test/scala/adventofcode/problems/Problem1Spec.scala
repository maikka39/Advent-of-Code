package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem1Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem1.part1(getInput(1, "sample.txt")) shouldBe "24000"
    }

    "solve the actual input" in {
      Problem1.part1(getInput(1, "input.txt")) shouldBe "69912"
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem1.part2(getInput(1, "sample.txt")) shouldBe "45000"
    }

    "solve the actual input" in {
      Problem1.part2(getInput(1, "input.txt")) shouldBe "208180"
    }
  }
}
