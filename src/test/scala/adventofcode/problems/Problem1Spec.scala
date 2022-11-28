package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem1Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem1.part1(getInput(1, "sample.txt")) shouldBe "514579"
    }

    "solve the actual input" in {
      Problem1.part1(getInput(1, "input.txt")) shouldBe "633216"
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem1.part2(getInput(1, "sample.txt")) shouldBe "241861950"
    }

    "solve the actual input" in {
      Problem1.part2(getInput(1, "input.txt")) shouldBe "68348924"
    }
  }
}
