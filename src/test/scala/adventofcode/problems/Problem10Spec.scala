package adventofcode.problems

import adventofcode.TestUtils
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Problem10Spec extends AnyWordSpec with Matchers with TestUtils {
  "part 1" should {
    "solve the sample input" in {
      Problem10.part1(getInput(10, "sample.txt")).answer shouldBe 13140
    }

    "solve the actual input" in {
      Problem10.part1(getInput(10, "input.txt")).answer shouldBe 12460
    }
  }

  "part 2" should {
    "solve the sample input" in {
      Problem10.part2(getInput(10, "sample.txt")).answer shouldBe "##  ##  ##  ##  ##  ##  ##  ##  ##  ##  \n###   ###   ###   ###   ###   ###   ### \n####    ####    ####    ####    ####    \n#####     #####     #####     #####     \n######      ######      ######      ####\n#######       #######       #######     \n "
    }

    "solve the actual input" in {
      Problem10.part2(getInput(10, "input.txt")).answer shouldBe "#### #### #### ###  ###   ##  #  # #    \n#       # #    #  # #  # #  # # #  #    \n###    #  ###  #  # #  # #  # ##   #    \n#     #   #    ###  ###  #### # #  #    \n#    #    #    #    # #  #  # # #  #    \n#### #### #    #    #  # #  # #  # #### \n "
    }
  }
}
