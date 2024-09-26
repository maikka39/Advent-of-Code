package adventofcode

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import adventofcode.days.Day1
import adventofcode.utils.FindPuzzle

class FindPuzzleSpec extends AnyWordSpec with Matchers {
  "dayReference" should {
    "load an existing day" in {
      FindPuzzle.findDayReference(1).isSuccess shouldBe true
      FindPuzzle.findDayReference(1).get shouldBe Day1
    }

    "fail on a non-existing day" in {
      FindPuzzle.findDayReference(-1).isFailure shouldBe true
    }
  }
}
