package channel_官方文档.抽象类型

object demo {

  def example(): Unit = {
    trait Buffer {
      type T
      val element: T
    }
    abstract class SeqBuffer extends Buffer {
      type U
      type T <: Seq[U]

      def length = element.length

      def aa
    }
    // 注意这里是如何借助另外一个抽象类型U来限定类型上边界的。
    // 通过声明类型T只可以是Seq[U]的子类（其中U是一个新的抽象类型），
    // 这个SeqBuffer类就限定了缓冲区中存储的元素类型只能是序列。
    //    class a extends SeqBuffer {
    //      override type U = this.type
    //      override type T = this.type
    //
    //      override def aa: Unit = ???
    //
    //      override val element: a.this.type = _
    //    }
  }

  def example1(): Unit = {
    trait Buffer {
      type T
      val element: T
    }
    abstract class SeqBuffer extends Buffer {
      type U
      type T <: Seq[U]

      def length = element.length
    }
    abstract class IntSeqBuffer extends SeqBuffer {
      override type U = Int
    }
    def newIntSeqBuf(elem1: Int, elem2: Int): IntSeqBuffer =
      new IntSeqBuffer {
        override type T = List[U]
        override val element: T = List(elem1, elem2)
      }

    val buf = newIntSeqBuf(7, 8)
    println("length = " + buf.length)
    println("content = " + buf.element)
  }

  def example2(): Unit = {
    abstract class Buffer[+T] {
      val element: T
    }
    abstract class SeqBuffer[U, +T <: Seq[U]] extends Buffer[T] {
      def length = element.length
    }
    def newIntSeqBuf(e1: Int, e2: Int): SeqBuffer[Int, Seq[Int]] =
      new SeqBuffer[Int, List[Int]] {
        override val element: List[Int] = List(e1, e2)
      }

    val buf = newIntSeqBuf(7, 8)
    println("length = " + buf.length)
    println("content = " + buf.element)
  }

  def main(args: Array[String]): Unit = {
    //    example()
    //    example1()
    example2()
  }
}
