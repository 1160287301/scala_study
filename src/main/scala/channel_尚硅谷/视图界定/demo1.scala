package channel_尚硅谷.视图界定

object demo1 {
  class Persion2(val name: String, val age: Int){
    override def toString: String = this.name + ", " +this.age
  }

  implicit def Persion2OrderPersion(p : Persion2) = new Ordered[Persion2] {
    override def compare(that: Persion2): Int = that.age - p.age
  }

  class CommonCompare2[T <% Ordered[T]](obj1: T, obj2: T){
    def geater = if (obj1 > obj2) obj1 else obj2
  }

  def main(args: Array[String]): Unit = {
    val o1 = new Persion2("o1", 12)
    val o2 = new Persion2("o2", 13)
    println(new CommonCompare2(o1, o2).geater)
  }

}
