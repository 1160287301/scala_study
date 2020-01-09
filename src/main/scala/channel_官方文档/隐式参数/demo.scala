package channel_官方文档.隐式参数

object demo {

  def example(): Unit = {
    abstract class Monoid[A] {
      def add(x: A, y: A): A

      def unit: A
    }
    implicit val stringMonoid: Monoid[String] = new Monoid[String] {
      override def add(x: String, y: String): String = x concat y

      override def unit: String = ""
    }
    implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
      override def add(x: Int, y: Int): Int = x + y

      override def unit: Int = 0
    }

    def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
      if (xs.isEmpty) m.unit
      else m.add(xs.head, sum(xs.tail))

    println(sum(List(1, 2, 3))) // uses IntMonoid implicitly
    //    println(sum(List("a", "b", "c"))) // uses StringMonoid implicitly

  }

  implicit val aa = "隐私参数语法糖";

  def main(args: Array[String]): Unit = {
//    example()
    println(implicitly[String])  //隐私参数语法糖
  }
}
