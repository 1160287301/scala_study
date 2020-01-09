package channel_尚硅谷.上界

object demo01 {
  /*
 编写一个通用类,可以进行int之间, float之间, 等实现了comparable接口的值得比较
  *
  */
  class CompareInt(n1: Int, n2: Int){
    def greater = if (n1 > n2) n1 else n2

  }

  class CommonCompare[T <: Comparable[T]](o1: T, o2: T) {
    def greater = if (o1.compareTo(o2) > 0) o1 else o2
  }

  def main(args: Array[String]): Unit = {
    // 传统方式
    val int1 = new CompareInt(10, 40).greater
    println(int1)
    //上界的方式
    val int2 = new CommonCompare(Integer.valueOf(10), Integer.valueOf(40)).greater
    println(int2)
    // 使用了隐式转换
    val int3 = new CommonCompare[java.lang.Integer](10, 40).greater
    println(int3)


  }

}
