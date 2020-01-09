package channel_官方文档.泛型类

class Stack[A] {
  private var elements: List[A] = Nil

  def push(x: A) {
    elements = x :: elements
  }

  def peek: A = elements.head

  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}

object demo {

  def simple_example(): Unit = {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    println(stack.pop())
    println(stack.pop())
  }

  def simple_example1(): Unit = {
    class Fruit {
      override def toString: String = this.getClass.getName
    }
    class Apple extends Fruit
    class Banana extends Fruit

    val stack = new Stack[Fruit]
    val apple = new Apple
    val banana = new Banana
    stack.push(apple)
    stack.push(banana)

    println(stack.pop())
    println(stack.pop())
  }


  def main(args: Array[String]): Unit = {
    //    simple_example()
    simple_example1()
  }
}
