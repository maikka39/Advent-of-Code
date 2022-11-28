package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem4Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem4.part1(getInput(4, "sample.txt")) shouldBe "2"
    }

    "solve the actual input" in {
      Problem4.part1(getInput(4, "input.txt")) shouldBe "239"
    }
  }

  "part 2" should {
    "not count invalid passports" in {
      Problem4.part2(getInput(4, "invalid.txt")) shouldBe "0"
    }

    "count valid passports" in {
      Problem4.part2(getInput(4, "valid.txt")) shouldBe "4"
    }

    "solve the actual input" in {
      Problem4.part2(getInput(4, "input.txt")) shouldBe "188"
    }
  }
}

