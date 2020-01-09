package channel_官方文档.组合类

object demo {
  def mixin(): Unit = {
    abstract class A {
      val message: String
    }
    class B extends A {
      override val message: String = "I'm an instance of class B"
    }
    trait C extends A {
      def loudMessage = message.toUpperCase()
    }
    class D extends B with C
    val d = new D
    println(d.message)
    println(d.loudMessage)
  }

  def mixin1(): Unit = {
    abstract class AbsIterator {
      type T

      def hasNext: Boolean

      def next(): T
    }
    class StringIterator(s: String) extends AbsIterator {
      type T = Char
      private var i = 0

      def hasNext = i < s.length

      def next() = {
        val ch = s charAt i
        i += 1
        ch
      }
    }

    trait RichIterator extends AbsIterator {
      def foreach(f: T => Unit): Unit = while (hasNext) f(next())
    }

    //    object StringIteratorTest extends App {  // 继承App trait可以不用写main方法而直接运行代码
    //
    //      class RichStringIter extends StringIterator("Scala") with RichIterator
    //
    //      val richStringIter = new RichStringIter
    //      richStringIter foreach println
    //    }
    class RichStringIter extends StringIterator("Scala") with RichIterator
    val richStringIter = new RichStringIter
    richStringIter foreach println
  }

  def main(args: Array[String]): Unit = {
    //    mixin()
    mixin1()
  }
}
