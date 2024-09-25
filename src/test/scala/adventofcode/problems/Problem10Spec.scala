package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem10Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem10.part1(getInput(10, "sample.txt")).answer shouldBe 4
    }

    "solve the second sample input" in {
      Problem10.part1(getInput(10, "sample2.txt")).answer shouldBe 8
    }

    "solve the actual input" in {
      Problem10.part1(getInput(10, "input.txt")).answer shouldBe 6923
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem10.part2(getInput(10, "sample3.txt")).answer shouldBe 4
    }

    "solve the second sample input" in {
      Problem10.part2(getInput(10, "sample4.txt")).answer shouldBe 4
    }

    "solve the third sample input" in {
      Problem10.part2(getInput(10, "sample5.txt")).answer shouldBe 8
    }

    "solve the fourth sample input" in {
      Problem10.part2(getInput(10, "sample6.txt")).answer shouldBe 10
    }

    "solve the actual input" in {
      Problem10.part2(getInput(10, "input.txt")).answer shouldBe 529
    }
  }
}
