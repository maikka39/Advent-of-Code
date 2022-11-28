package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem6Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem6.part1(getInput(6, "sample.txt")) shouldBe "11"
    }

    "solve the actual input" in {
      Problem6.part1(getInput(6, "input.txt")) shouldBe "6161"
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem6.part2(getInput(6, "sample.txt")) shouldBe "6"
    }

    "solve the actual input" in {
      Problem6.part2(getInput(6, "input.txt")) shouldBe "2971"
    }
  }
}

