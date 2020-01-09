package channel_官方文档.类

object demo {
  def class_definition(): Unit = {
    class Point(var x: Int, var y: Int) {
      def move(dx: Int, dy: Int): Unit = {
        x = x + dx
        y = y + dy
      }

      override def toString: String =
        s"($x, $y)"
    }
    val point1 = new Point(2, 3)
    println(point1)
  }

  def getter_setter(): Unit = {
    class Point {
      private var _x = 0
      private var _y = 0
      private val bound = 100

      def x = _x

      def x_=(newValue: Int): Unit = {
        if (newValue < bound) _x = newValue else printWarning
      }

      def y = _y

      def y_=(newValue: Int): Unit = {
        if (newValue < bound) _y = newValue else printWarning
      }

      private def printWarning = println("WARNING: Out of bounds")
    }
    val point1 = new Point
    point1.x = 99
    point1.y = 101 // prints the warning
  }

  def var_val(): Unit = {
    class Point(val x: Int, val y: Int)
    val point = new Point(1, 2)
    //    point.x = 3  // <-- does not compile
    class Point1(x: Int, y: Int)
    val point1 = new Point(1, 2)
    //    point1.x // <-- does not compile
  }

  def main(args: Array[String]): Unit = {
    //    class_definition()
    getter_setter()
  }

}
