package adventofcode.days

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Day5Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Day5.part1(getInput(5, "sample.txt")).answer shouldBe 35
    }

    "solve the actual input" in {
      Day5.part1(getInput(5, "input.txt")).answer shouldBe 662197086
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Day5.part2(getInput(5, "sample.txt")).answer shouldBe 46
    }

    "solve the actual input" in {
      Day5.part2(getInput(5, "input.txt")).answer shouldBe 52510809
    }
  }
}
