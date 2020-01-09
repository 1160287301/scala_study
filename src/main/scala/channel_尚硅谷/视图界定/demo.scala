package channel_尚硅谷.视图界定

object demo {

  /*
  视图界定除了上下界的作用外 还能自动导入隐式转换
   */

  class CommonCompare[T <% Comparable[T]](o1: T, o2: T) {
    def greater = if (o1.compareTo(o2) > 0) o1 else o2
  }

  def main(args: Array[String]): Unit = {
    // 自动使用了隐式转换
    val int3 = new CommonCompare(10, 40).greater
    println(int3)


  }
}
