package channel_官方文档.提取器对象

import scala.util.Random

object demo {

  def simple_example(): Unit = {
    object CustomerID {

      def apply(name: String) = s"$name--${Random.nextLong}"

      def unapply(customerID: String): Option[String] = {
        val stringArray: Array[String] = customerID.split("--")
        if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
      }
    }

    val customer1ID = CustomerID("Sukyoung") // Sukyoung--23098234908
    customer1ID match {
      case CustomerID(name) => println(name) // prints Sukyoung
      case _ => println("Could not extract a CustomerID")
    }
  }

  def simple_example1(): Unit = {
    object CustomerID {

      def apply(name: String) = s"$name--${Random.nextLong}"

      def unapply(customerID: String): Option[String] = {
        val stringArray: Array[String] = customerID.split("--")
        if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
      }
    }

    val customer2ID = CustomerID("Nico")
    val CustomerID(name) = customer2ID
    println(name) // prints Nico

  }

  def simple_example2(): Unit = {
    object CustomerID {

      def apply(name: String) = s"$name--${Random.nextLong}"

      def unapply(customerID: String): Option[String] = {
        val stringArray: Array[String] = customerID.split("--")
        if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
      }
    }
    val CustomerID(name2) = "1--asdfasdfasdf"
    println(name2)
    //    val CustomerID(name3) = "-asdfasdfasdf"  // scala.MatchError
    //    println(name3)
  }

  def main(args: Array[String]): Unit = {
    //    simple_example()
    //    simple_example1()
    simple_example2()
  }
}
