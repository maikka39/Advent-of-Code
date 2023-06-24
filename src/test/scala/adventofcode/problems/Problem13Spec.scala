package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem13Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem13.part1(getInput(13, "sample.txt")).answer shouldBe 13
    }

    "solve the actual input" in {
      Problem13.part1(getInput(13, "input.txt")).answer shouldBe 5623
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem13.part2(getInput(13, "sample.txt")).answer shouldBe 140
    }

    "solve the actual input" in {
      Problem13.part2(getInput(13, "input.txt")).answer shouldBe 20570
    }
  }
}
