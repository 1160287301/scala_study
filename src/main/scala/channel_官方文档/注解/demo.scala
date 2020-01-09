package channel_官方文档.注解

object demo {

  def example(): Unit = {
    @deprecated("deprecation message", "release # which deprecates method")
    def hello = "hola"

    hello
  }

  def example1(): Unit = {
    // 如果不满足条件，某些注解实际上会导致编译失败。
    // 例如，注解 @tailrec 确保方法是 尾递归。 尾递归可以保持内存需求不变。 以下是它在计算阶乘的方法中的用法：
    // 尾递归: 进入下一个函数不再需要上一个函数的环境了，得出结果以后直接返回
    // 非尾递归: 下一个函数结束以后此函数还有后续，所以必须保存本身的环境以供处理返回值。
    import scala.annotation.tailrec

    def factorial(x: Int): Int = {

      @tailrec
      def factorialHelper(x: Int, accumulator: Int): Int = {
        if (x == 1) accumulator
        //        else x * factorialHelper(x - 1, accumulator * x) // 会报错
        else factorialHelper(x - 1, accumulator * x)
      }

      factorialHelper(x, 1)
    }
  }

  def main(args: Array[String]): Unit = {
    //    example()
    example1()
  }
}
