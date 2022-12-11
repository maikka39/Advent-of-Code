package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem11Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem11.part1(getInput(11, "sample.txt")).answer shouldBe 10605
    }

    "solve the actual input" in {
      Problem11.part1(getInput(11, "input.txt")).answer shouldBe 117624
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem11.part2(getInput(11, "sample.txt")).answer shouldBe 2713310158L
    }

    "solve the actual input" in {
      Problem11.part2(getInput(11, "input.txt")).answer shouldBe 16792940265L
    }
  }
}
