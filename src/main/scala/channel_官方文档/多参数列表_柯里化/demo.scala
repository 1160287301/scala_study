package channel_官方文档.多参数列表_柯里化

object demo {

  def simple_example(): Unit = {
    // foldLeft从左到右，以此将一个二元运算op应用到初始值z和该迭代器（traversable)的所有元素上
    // def foldLeft[B](z: B)(op: (B, A) => B): B
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var res = numbers.foldLeft(0)((m, n) => m + n)
    println(res)
    res = numbers.foldLeft(0)(_ + _)
    println(res)
  }

  def simple_example1(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numberFunc = numbers.foldLeft(List[Int]()) _

    val squares = numberFunc((xs, x) => xs :+ x * x)
    println(squares.toString())
    val cubes = numberFunc((xs, x) => xs :+ x * x * x)
    println(cubes.toString())
  }

  def simple_example2(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println(numbers.foldLeft(0)((sum, item) => sum + item)) // Generic Form
    println(numbers.foldRight(0)((sum, item) => sum + item)) // Generic Form

    println(numbers.foldLeft(0)(_ + _)) // Curried Form
    println(numbers.foldRight(0)(_ + _)) // Curried Form

    println((0 /: numbers) (_ + _)) // Used in place of foldLeft
    println((numbers :\ 0) (_ + _)) // Used in place of foldRight

  }

  def main(args: Array[String]): Unit = {
    //    simple_example()
    //    simple_example1()
    simple_example2()
  }
}
