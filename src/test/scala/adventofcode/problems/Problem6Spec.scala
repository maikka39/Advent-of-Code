package adventofcode.problems

import adventofcode.TestUtils
import adventofcode.utils.StringUtils.*
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Problem6Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem6.part1(getInput(6, "sample.txt")).answer shouldBe 7

      Problem6.part1("bvwbjplbgvbhsrlpgdmjqwftvncz".toInput).answer shouldBe 5
      Problem6.part1("nppdvjthqldpwncqszvftbrmjlhg".toInput).answer shouldBe 6
      Problem6.part1("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg".toInput).answer shouldBe 10
      Problem6.part1("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw".toInput).answer shouldBe 11
    }

    "solve the actual input" in {
      Problem6.part1(getInput(6, "input.txt")).answer shouldBe 1542
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem6.part2(getInput(6, "sample.txt")).answer shouldBe 19

      Problem6.part2("bvwbjplbgvbhsrlpgdmjqwftvncz".toInput).answer shouldBe 23
      Problem6.part2("nppdvjthqldpwncqszvftbrmjlhg".toInput).answer shouldBe 23
      Problem6.part2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg".toInput).answer shouldBe 29
      Problem6.part2("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw".toInput).answer shouldBe 26
    }

    "solve the actual input" in {
      Problem6.part2(getInput(6, "input.txt")).answer shouldBe 3153
    }
  }
}
