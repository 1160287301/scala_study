package channel_官方文档.特质

import scala.collection.mutable.ArrayBuffer

object demo {

  def user_trait(): Unit = {
    trait Iterator[A] {
      def hasNext: Boolean

      def next(): A
    }

    class IntIterator(to: Int) extends Iterator[Int] {
      private var current = 0

      override def hasNext: Boolean = current < to

      override def next(): Int = {
        if (hasNext) {
          val t = current
          current += 1
          t
        } else 0
      }
    }
    val iterator = new IntIterator(2)
    println(iterator.next())
    println(iterator.next())
    println(iterator.next())
  }

  def sub_type(): Unit = {
    trait Pet {
      val name: String
    }

    class Cat(val name: String) extends Pet
    class Dog(val name: String) extends Pet
    val dog = new Dog("Harry")
    val cat = new Cat("Sally")
    val animals = ArrayBuffer.empty[Pet]
    animals.append(dog)
    animals.append(cat)
    animals.foreach {
      per => println(per.name)
    }
  }

  def main(args: Array[String]): Unit = {
//    user_trait()
    sub_type()
  }
}
