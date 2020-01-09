package channel_官方文档.默认参数值

object demo {

  def example(): Unit = {
    def log(message: String, level: String = "INFO") = println(s"$level: $message")

    log("System starting") // prints INFO: System starting
    log("User not found", "WARNING") // prints WARNING: User not found

    // 注意从Java代码中调用时，Scala中的默认参数则是必填的（非可选），如：
    // Point.scala
    class Point(val x: Double = 0, val y: Double = 0)
    // Main.java
    //    public class Main {
    //      public static void main(String[] args) {
    //        Point point = new Point(1);  // does not compile
    //      }
    //    }
  }

  def main(args: Array[String]): Unit = {
    example()
  }
}
