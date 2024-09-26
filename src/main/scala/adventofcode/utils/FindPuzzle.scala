package adventofcode.utils

import adventofcode.Day

import scala.util.Try

object FindPuzzle {
  def findDayReference(dayNumber: Int): Try[Day] = Try {
    import scala.reflect.runtime.universe as ru
    val runtimeMirror = ru.runtimeMirror(getClass.getClassLoader)
    val path = s"adventofcode.days.Day$dayNumber"
    val staticModule = runtimeMirror.staticModule(path)
    val reflectModule = runtimeMirror.reflectModule(staticModule)
    reflectModule.instance.asInstanceOf[Day]
  }
}
