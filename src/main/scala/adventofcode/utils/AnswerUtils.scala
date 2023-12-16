package adventofcode.utils

import adventofcode.Answer

object AnswerUtils {
  given Conversion[Int, Answer] = Answer(_)
  given Conversion[Long, Answer] = Answer(_)
  given Conversion[String, Answer] = Answer(_)
}
