package adventofcode.utils

import adventofcode.Problem

import scala.util.Try

object FindPuzzle {
  def findProblemReference(problemNumber: Int): Try[Problem] = Try {
    import scala.reflect.runtime.universe as ru
    val runtimeMirror = ru.runtimeMirror(getClass.getClassLoader)
    val path = s"adventofcode.problems.Problem$problemNumber"
    val staticModule = runtimeMirror.staticModule(path)
    val reflectModule = runtimeMirror.reflectModule(staticModule)
    reflectModule.instance.asInstanceOf[Problem]
  }
}
