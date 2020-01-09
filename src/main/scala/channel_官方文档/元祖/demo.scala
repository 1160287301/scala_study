package channel_官方文档.元祖

object demo {

  def test(): Unit = {
    val ingredient = ("Sugar", 25): Tuple2[String, Int]
    // 访问元素
    println(ingredient._1)
    println(ingredient._2)
    // 解构元组数据
    val (name, quantity) = ingredient
    println(name)
    println(quantity)
  }

  def pattern_match(): Unit = {
    val planetDistanceFromSun = List(("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6), ("Mars", 227.9), ("Jupiter", 778.3))
    planetDistanceFromSun.foreach { tuple => {
      tuple match {
        case ("Mercury", distance) => println(s"Mercury is $distance millions km from Sun")
        case p if (p._1 == "Venus") => println(s"Venus is ${p._2} millions km far from Sun")
        case p if (p._1 == "Earth") => println(s"Blue planet is ${p._2} millions km far from Sun")
        case _ => println("Too far....")
      }
    }
    }
  }

  def tuple_for(): Unit = {
    val numPairs = List((1, 1), (2, 2), (3, 3))
    for ((a, b) <- numPairs) {
      println(a * b)
    }
  }

  def main(args: Array[String]): Unit = {
    //    test()
    //    pattern_match()
    tuple_for()
  }
}
