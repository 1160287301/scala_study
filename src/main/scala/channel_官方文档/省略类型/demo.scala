package channel_官方文档.省略类型

object demo {

  def example(): Unit = {
    // Scala 编译器通常可以推断出表达式的类型，因此你不必显式地声明它。
    val businessName = "Montreux Jazz Café"

    // 编译器可以推断出方法的返回类型为 Int，因此不需要明确地声明返回类型
    def squareOf(x: Int) = x * x

    // 对于递归方法，编译器无法推断出结果类型。 下面这个程序就是由于这个原因而编译失败
    // def fac(n: Int) = if (n == 0) 1 else n * fac(n - 1)
    def fac(n: Int): Int = if (n == 0) 1 else n * fac(n - 1)

    // 当调用 多态方法 或实例化 泛型类 时，也不必明确指定类型参数。
    // Scala 编译器将从上下文和实际方法的类型/构造函数参数的类型推断出缺失的类型参数
    case class MyPair[A, B](x: A, y: B)
    val p = MyPair(1, "scala") // type: MyPair[Int, String]

    def id[T](x: T) = x

    val q = id(1) // type: Int


    // 编译器从不推断方法形式参数的类型。 但是，在某些情况下，当函数作为参数传递时，编译器可以推断出匿名函数形式参数的类型。
    // 方法 map 的形式参数是 f: A => B。 因为我们把整数放在 Seq 中，编译器知道 A 是 Int 类型 (即 x 是一个整数)。
    // 因此，编译器可以从 x * 2 推断出 B 是 Int 类型。
    Seq(1, 3, 4).map(x => x * 2) // List(2, 6, 8)


    //    var obj = null
    //    obj = new AnyRef
  }

  def main(args: Array[String]): Unit = {
    example()
  }
}
