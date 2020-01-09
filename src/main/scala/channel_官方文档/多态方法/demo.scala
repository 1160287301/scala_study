package channel_官方文档.多态方法

object demo {

  def example(): Unit = {
    def listofDuplicates[A](x: A, length: Int): List[A] = {
      if (length < 1) Nil
      else x :: listofDuplicates(x, length - 1)
    }

    println(listofDuplicates[Int](3, 4))
    println(listofDuplicates(3, 4))
    println(listofDuplicates("La", 4))
  }

  def main(args: Array[String]): Unit = {
    example()
  }
}
