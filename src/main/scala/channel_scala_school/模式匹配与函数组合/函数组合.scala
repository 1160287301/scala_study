package channel_scala_school.模式匹配与函数组合

object 函数组合 {

  def example() = {
    def f(s: String) = "f(" + s + ")"

    def g(s: String) = "g(" + s + ")"

    //compose 组合其他函数形成一个新的函数 f(g(x))
    val fcomposeg = f _ compose g _
    println(fcomposeg("compose"))

    // andThen 和 compose很像，但是调用顺序是先调用第一个函数，然后调用第二个，即g(f(x)
    val fandtheng = f _ andThen g _
    println(fandtheng("andThen"))
  }


  def example1() = {
    val one: PartialFunction[Int, String] = {
      case 1 => "one"
    }
    // isDefinedAt 是PartialFunction的一个方法，用来确定PartialFunction是否能接受一个给定的参数
    println(one.isDefinedAt(1))
    println(one.isDefinedAt(2))
    println(one(1))
  }

  def example2(): Unit = {
    //那么究竟什么是case语句？
    //这是一个名为PartialFunction的函数的子类。
    //多个case语句的集合是什么？
    //他们是共同组合在一起的多个PartialFunction。

    // PartialFunctions可以使用orElse组成新的函数，得到的PartialFunction反映了是否对给定参数进行了定义
    val one: PartialFunction[Int, String] = {
      case 1 => "one"
    }
    val two: PartialFunction[Int, String] = {
      case 2 => "two"
    }
    val three: PartialFunction[Int, String] = {
      case 3 => "three"
    }
    val wildcard: PartialFunction[Int, String] = {
      case _ => "something else"
    }
    val partial = one orElse two orElse three orElse wildcard
    println(partial(1))
    println(partial(2))
    println(partial(3))
    println(partial(4))
  }

  def example3(): Unit = {
    case class PhoneExt(name: String, ext: Int)
    val extensions = List(PhoneExt("steve", 100), PhoneExt("robey", 200))
    extensions.filter {
      case PhoneExt(name, ext) => ext < 200
    }
    println(extensions)
  }

  def main(args: Array[String]): Unit = {
    //    example()
    //    example1()
    //    example2()
    example3()
  }
}
