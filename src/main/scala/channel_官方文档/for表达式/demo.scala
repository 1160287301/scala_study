package channel_官方文档.for表达式

object demo {

  def simple_example(): Unit = {
    case class User(name: String, age: Int)
    val userBase = List(
      User("a", 1),
      User("b", 2),
      User("c", 3),
      User("d", 4),
      User("e", 5)
    )
    val twentySomethings = for (user <- userBase if (user.age >= 3))
      yield user.name
    twentySomethings.foreach(name => println(name))
  }


  def simple_example1(): Unit = {
    def foo(n: Int, v: Int) =
      for (i <- 0 until n;
           j <- i until n if i + j == v)
        yield (i, j)

    foo(10, 10) foreach {
      case (i, j) =>
        println(s"($i, $j) ") // prints (1, 9) (2, 8) (3, 7) (4, 6) (5, 5)
    }
  }


  def simple_example2(): Unit = {
    def foo(n: Int, v: Int) =
      for (i <- 0 until n;
           j <- i until n if i + j == v)
        println(s"($i, $j)")

    foo(10, 10)
  }

  def main(args: Array[String]): Unit = {
    //    simple_example()
    //    simple_example1()
    simple_example2()
  }
}
