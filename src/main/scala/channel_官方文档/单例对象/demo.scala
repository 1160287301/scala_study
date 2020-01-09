package channel_官方文档.单例对象

import scala.math._

case class demo(radius: Double) {
  // 伴生类
  import demo._

  def area: Double = calculateArea(radius)
}


object demo {
  // 伴生对象
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)

  def main(args: Array[String]): Unit = {
    val circle1 = new demo(5.0)

    println(circle1.area)
  }

}


