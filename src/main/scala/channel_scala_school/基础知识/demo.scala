package channel_scala_school.基础知识

object demo {

  def example(): Unit = {
    // apply 方法

    //当类或对象有一个主要用途的时候，apply方法为你提供了一个很好的语法糖
    class Foo() {
      val target = "foo"
    }
    object FooMarker {
      def apply() = {
        new Foo()
      }
    }
    val newFoo = FooMarker()
    println(newFoo.target)
    // 或者
    class Bar {
      def apply() = "bar"
    }
    val bar = new Bar
    println(bar())
  }

  def example1(): Unit = {
    // 单例对象
    object Timer {
      var count = 0

      def currentCount(): Long = {
        count += 1
        count
      }
    }
    println(Timer.currentCount())
    // 单例对象可以和类具有相同的名称，此时该对象也被称为“伴生对象”。我们通常将伴生对象作为工厂使用。
    // 下面是一个简单的例子，可以不需要使用’new’来创建一个实例了。
    class Bar(foo: String) {
      val target = foo
    }
    object Bar {
      def apply(foo: String) = new Bar(foo)
    }
    val b = Bar("aaa")
    println(b.target)
  }

  def example2(): Unit = {
    // 函数即对象
    object addOne extends Function1[Int, Int] {
      override def apply(v1: Int): Int = v1 + 1
    }
    println(addOne(1))

    // 类也可以扩展Function，这些类的实例可以使用()调用
    class AddOne extends Function1[Int, Int] {
      override def apply(v1: Int): Int = {
        v1 + 1
      }
    }
    val plusOne = new AddOne()
    println(plusOne(1))
  }

  def example3(): Unit = {
    // 匹配类型
    def bigger(o: Any): Any = {
      o match {
        case i: Int if i < 0 => i - 1
        case i: Int => i + 1
        case d: Double if d < 0.0 => d - 0.1
        case d: Double => d + 0.1
        case text: String => text + "s"
      }
    }

    println(bigger(1))
  }

  def example4(): Unit = {
    // 参数多种类型
    type ¬[A] = A => Nothing
    type ¬¬[A] = ¬[¬[A]]
    type ∨[T, U] = ¬[¬[T] with ¬[U]]
    type |∨|[T, U] = {type λ[X] = ¬¬[X] <:< (T ∨ U)}

    def size[T: (Int |∨| String)#λ](t: T) = println(t)

    size(1)
    size("2")

  }

  def example5(): Unit = {
    // 异常
    def division(a: Int, b: Int): Unit = {
      a / b
    }

    try {
      division(1, 0)
    } catch {
      case e: Exception => println(e)
    }
  }

  def main(args: Array[String]): Unit = {
    //    example()
    //    example1()
    //    example2()
    //    example3()
    //    example4()
    example5()
  }
}
