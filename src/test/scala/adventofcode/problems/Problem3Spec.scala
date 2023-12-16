package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem3Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem3.part1(getInput(3, "sample.txt")).answer shouldBe 4361
    }

    "solve the actual input" in {
      Problem3.part1(getInput(3, "input.txt")).answer shouldBe 549908
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem3.part2(getInput(3, "sample.txt")).answer shouldBe 467835
    }

    "solve the actual input" in {
      Problem3.part2(getInput(3, "input.txt")).answer shouldBe 81166799
    }
  }
}
