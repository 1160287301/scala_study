package channel_官方文档.形变

object demo2 {

  def example(): Unit = {
    class Animal {}
    class Bird extends Animal {}
    class Consumer[T](t: T) {

    }
    class Test extends App {
      val c: Consumer[Bird] = new Consumer[Bird](new Bird)
      //      val c2:Consumer[Animal] = c  // 编译失败 类型不符合预期
    }
  }

  def example1(): Unit = {
    //因为Consumer定义成协变类型的，所以Consumer[Bird]是Consumer[Animal]的子类型，所以它可以被赋值给c2。
    class Animal {}
    class Bird extends Animal {}
    class Consumer[+T](t: T) {
    }
    class Test extends App {
      val c: Consumer[Bird] = new Consumer[Bird](new Bird)
      val c2: Consumer[Animal] = c
    }
  }

  def example2(): Unit = {
    //这里Consumer[-T]定义成逆变类型，所以Consumer[Animal]被看作Consumer[Bird]的子类型，故c可以被赋值给c2。
    class Animal {}
    class Bird extends Animal {}
    class Consumer[-T](t: T) {
    }
    class Test extends App {
      val c: Consumer[Animal] = new Consumer[Animal](new Animal)
      val c2: Consumer[Bird] = c
    }
  }

  def example3(): Unit = {
    class Consumer[+T](t: T) {
      //编译会出错。出错信息为 "Covariant type T occurs in contravariant position in type T of value t"。
      //      def use(t: T) = {}
      //但是如果返回结果为类型参数则没有问题
      def get(): T = {
        t
      }

      //为了在方法的参数中使用类型参数，你需要定义下界
      class Consumer[+T](t: T) {
        def use[U >: T](u: U) = {
          println(u)
        }
      }

    }
  }

  def main(args: Array[String]): Unit = {
    example()
    example1()
    example2()
    example3() //下界lower bounds
  }
}
