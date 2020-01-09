package channel_官方文档.复合类型

object demo {

  def example(): Unit = {
    trait Cloneable extends java.lang.Cloneable {
      override def clone(): Cloneable = {
        super.clone().asInstanceOf[Cloneable]
      }
    }
    trait Resetable {
      def reset: Unit
    }
    //接受一个对象，克隆它并重置原始对象
    def cloneAndReset(obj: Cloneable with Resetable): Cloneable = {
      val cloned = obj.clone()
      obj.reset
      cloned
    }
  }

  def main(args: Array[String]): Unit = {
    example()
  }
}
