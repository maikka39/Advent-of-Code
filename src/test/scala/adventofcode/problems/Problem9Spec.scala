package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem9Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem9.part1(getInput(9, "sample.txt")).answer shouldBe 13
    }

    "solve the actual input" in {
      Problem9.part1(getInput(9, "input.txt")).answer shouldBe 6284
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem9.part2(getInput(9, "sample.txt")).answer shouldBe 1
      Problem9.part2(getInput(9, "sample2.txt")).answer shouldBe 36
    }

    "solve the actual input" in {
      Problem9.part2(getInput(9, "input.txt")).answer shouldBe 2661
    }
  }
}
