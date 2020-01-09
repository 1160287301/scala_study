package channel_尚硅谷.下界

object demo {
  /*
  scala下界使用小结
  1.不能使用上界的思路来类推下界
  2.对于下界,能传入任何类型, 只是处理的方式不一样
  3.传入与animal直系的类,是animal父类, 按父类的方法处理, 是animal子类, 按animal处理(会调用子类重写的方法)
   */
  def main(args: Array[String]): Unit = {
    seq_sound(Seq(new Earth)).map(_.sound)
    seq_sound(Seq(new Animal)).map(_.sound)
    seq_sound(Seq(new Bird)).map(_.sound)
    seq_sound(Seq(new MOON)) // 不报错
  }

  def seq_sound[T >: Animal](things: Seq[T]) = things

  class Earth{
    def sound: Unit ={
      println("hello world!!")
    }
  }
  class Animal extends Earth{
    override def sound: Unit = {
      println("animal sound!!")
    }
  }
  class Bird extends Animal{
    override def sound: Unit = {
      println("bird sound!!")
    }
  }
  class MOON {
    def sound: Unit = {
      println("MOON sound!!")
    }
  }

}
