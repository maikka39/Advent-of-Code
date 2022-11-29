package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem8Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem8.part1(getInput(8, "sample.txt")) shouldBe "5"
    }

    "solve the actual input" in {
      Problem8.part1(getInput(8, "input.txt")) shouldBe "1262"
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem8.part2(getInput(8, "sample.txt")) shouldBe "8"
    }

    "solve the actual input" in {
      Problem8.part2(getInput(8, "input.txt")) shouldBe "1643"
    }
  }
}

