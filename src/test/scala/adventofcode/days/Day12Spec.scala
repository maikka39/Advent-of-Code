package adventofcode.days

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Day12Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Day12.part1(getInput(12, "sample.txt")).answer shouldBe 21
    }

    "solve the actual input" in {
      Day12.part1(getInput(12, "input.txt")).answer shouldBe 7694
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Day12.part2(getInput(12, "sample.txt")).answer shouldBe 525152
    }

    "solve the actual input" in {
      Day12.part2(getInput(12, "input.txt")).answer shouldBe 5071883216318L
    }
  }
}
