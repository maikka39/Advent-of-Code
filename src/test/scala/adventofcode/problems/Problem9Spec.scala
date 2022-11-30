package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem9Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem9.part1(getInput(9, "sample.txt").prepended("5")) shouldBe "127"
    }

    "solve the actual input" in {
      Problem9.part1(getInput(9, "input.txt").prepended("25")) shouldBe "32321523"
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem9.part2(getInput(9, "sample.txt").prepended("5")) shouldBe "62"
    }

    "solve the actual input" in {
      Problem9.part2(getInput(9, "input.txt").prepended("25")) shouldBe "4794981"
    }
  }
}

