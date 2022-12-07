package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem7Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem7.part1(getInput(7, "sample.txt")).answer shouldBe 95437
    }

    "solve the actual input" in {
      Problem7.part1(getInput(7, "input.txt")).answer shouldBe 1428881
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem7.part2(getInput(7, "sample.txt")).answer shouldBe 24933642
    }

    "solve the actual input" in {
      Problem7.part2(getInput(7, "input.txt")).answer shouldBe 10475598
    }
  }
}
