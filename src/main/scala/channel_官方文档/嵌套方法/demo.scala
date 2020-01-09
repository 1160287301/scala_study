package channel_官方文档.嵌套方法

object demo {

  def factorial(x: Int): Unit = {
    def fact(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else fact(x - 1, x * accumulator)
    }

    println(fact(x, 1))
  }

  def main(args: Array[String]): Unit = {
    factorial(2)
    factorial(3)
  }
}
