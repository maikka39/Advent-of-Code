package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem2Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem2.part1(getInput(2, "sample.txt")) shouldBe "2"
    }

    "solve the actual input" in {
      Problem2.part1(getInput(2, "input.txt")) shouldBe "591"
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem2.part2(getInput(2, "sample.txt")) shouldBe "1"
    }

    "solve the actual input" in {
      Problem2.part2(getInput(2, "input.txt")) shouldBe "335"
    }
  }
}

