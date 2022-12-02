package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Problem2Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem2.part1(getInput(2, "sample.txt")).answer shouldBe 15
    }

    "solve the actual input" in {
      Problem2.part1(getInput(2, "input.txt")).answer shouldBe 15337
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem2.part2(getInput(2, "sample.txt")).answer shouldBe 12
    }

    "solve the actual input" in {
      Problem2.part2(getInput(2, "input.txt")).answer shouldBe 11696
    }
  }
}
