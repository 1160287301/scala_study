package channel_官方文档.隐式转换

object demo {

  def example(): Unit = {
    implicit def list2ordered[A](x: List[A])(implicit elem2ordered: A => Ordered[A]): Ordered[List[A]] =
      new Ordered[List[A]] {
        override def compare(that: List[A]): Int = 1
      }

    implicit def int2Integer(x: Int) =
      java.lang.Integer.valueOf(x)
  }

  def main(args: Array[String]): Unit = {
    example()
  }
}
