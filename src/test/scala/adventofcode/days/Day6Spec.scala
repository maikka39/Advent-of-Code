package adventofcode.days

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Day6Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Day6.part1(getInput(6, "sample.txt")).answer shouldBe 288
    }

    "solve the actual input" in {
      Day6.part1(getInput(6, "input.txt")).answer shouldBe 633080
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Day6.part2(getInput(6, "sample.txt")).answer shouldBe 71503
    }

    "solve the actual input" in {
      Day6.part2(getInput(6, "input.txt")).answer shouldBe 20048741
    }
  }
}
