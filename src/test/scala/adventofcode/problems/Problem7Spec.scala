package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem7Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem7.part1(getInput(7, "sample.txt")) shouldBe "4"
    }

    "solve the actual input" in {
      Problem7.part1(getInput(7, "input.txt")) shouldBe "316"
    }
  }

  "part 2" should {
    "solve the first sample input" in {
      Problem7.part2(getInput(7, "sample.txt")) shouldBe "32"
    }

    "solve the second sample input" in {
      Problem7.part2(getInput(7, "sample2.txt")) shouldBe "126"
    }

    "solve the actual input" in {
      Problem7.part2(getInput(7, "input.txt")) shouldBe "11310"
    }
  }
}

