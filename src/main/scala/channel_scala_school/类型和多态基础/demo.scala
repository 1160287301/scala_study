package channel_scala_school.类型和多态基础

object demo {

  def example(): Unit = {
    // 参数化多态性
    val res = 2 :: 1 :: "bar" :: "foo" :: Nil

    def drop1[A](l: List[A]) = l.tail

    println(drop1(res))
  }

  def example1(): Unit = {
    // Scala有秩1多态性
    def toList[A](a: A) = List(a)

    //    def foo[A, B](f: A => List[A], b: B) = f(b)
    def foo(f: Int => List[Int], b: Int) = f(b)

    println(foo((x: Int) => {
      List(1, 2, 3, x)
    }, 1).tail)
  }

  def main(args: Array[String]): Unit = {
    //    example()
    example1()
  }
}
