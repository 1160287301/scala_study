package channel_scala_school.集合

object demo {

  def example(): Unit = {
    val array = Array(1, 2, 3, 4, 5)
    array(3) = 3
    array.foreach(println)

    //列表是有序的，可以包含重复项，不可变
    val list_ = List(1, 2, 3, 4, 5)
    //    list_(3) = 3 value update is not a member of List[Int]
    list_.foreach(println)

    val set_ = Set(1, 2, 3, 4)
    //set_(2) = 2  Error:(16, 5) value update is not a member of scala.collection.immutable.Set[Int]
    set_.foreach(println)

    val tuple = ("1", "2")
    println(tuple._1)

    val m = Map(1 -> "one", 2 -> "two")
    println(m.getOrElse(1, "2"))
    println("==================")

    //映射的值可以是映射甚至是函数
    def timesTwo(i: Any) = {
      i
    }

    val m2 = Map("timesTwo" -> {
      timesTwo(_)
    })
    val c = "000"
    val cc = m2.get("timesTwo") match {
      case Some(function1) => function1(c)
      case _ => 1
    }
    println(cc)
  }

  def main(args: Array[String]): Unit = {
    example()
  }
}
