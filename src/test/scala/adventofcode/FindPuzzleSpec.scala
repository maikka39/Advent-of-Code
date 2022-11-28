package adventofcode

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import adventofcode.problems.Problem1

class FindPuzzleSpec extends AnyWordSpec with Matchers {
  "problemReference" should {
    "load an existing problem" in {
      FindPuzzle.findProblemReference(1).isSuccess shouldBe true
      FindPuzzle.findProblemReference(1).get shouldBe Problem1
    }

    "fail on a non-existing problem" in {
      FindPuzzle.findProblemReference(-1).isFailure shouldBe true
    }
  }
}
