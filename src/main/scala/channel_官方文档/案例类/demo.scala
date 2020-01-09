package channel_官方文档.案例类

object demo {

  def defined(): Unit = {
    case class Book(isbn: String)
    // 实例化案例类时，并没有使用关键字new，这是因为案例类有一个默认的apply方法来负责对象的创建
    // 当你创建包含参数的案例类时，这些参数是公开（public）的val
    case class Message(sender: String, recipient: String, body: String)
    val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")

    println(message1.sender) // prints guillaume@quebec.ca
    //    message1.sender = "travis@washington.us"  // this line does not compile

  }

  def compare(): Unit = {
    // 案例类在比较的时候是按值比较而非按引用比较
    case class Message(sender: String, recipient: String, body: String)
    val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
    val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
    val messagesAreTheSame = message2 == message3 // true
    println(messagesAreTheSame)
  }

  def copy(): Unit = {
    case class Message(sender: String, recipient: String, body: String)
    val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
    val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
    println(message5.sender) // travis@washington.us
    println(message5.recipient) // claire@bourgogne.fr
    println(message5.body) // "Me zo o komz gant ma amezeg"
  }

  def main(args: Array[String]): Unit = {
    //    defined()
    //    compare()
    copy()
  }
}
