package channel_官方文档.传名参数

object demo {

  def example(): Unit = {
    // 传名参数的优点是，如果它们在函数体中未被使用，则不会对它们进行求值, 会被计算多次
    // 所以该函数会打印2 1 关闭
    def whileLoop(condition: => Boolean)(body: => Unit): Unit =
      if (condition) {
        body
        whileLoop(condition)(body)
      }

    var i = 2
    whileLoop(i > 0) {
      println(i)
      i -= 1
    }
  }

  def example1(): Unit = {
    // 传值参数的优点是它们仅被计算一次
    // 所以该函数会打印2 然后不会关闭
    def whileLoop(condition: Boolean)(body: Unit): Unit =
      if (condition) {
        body
        whileLoop(condition)(body)
      }

    var i = 2

    whileLoop(i > 0) {
      println(i)
      i -= 1
    }
  }


  def main(args: Array[String]): Unit = {
    //    example()
    example1()
  }
}
