package channel_官方文档.类型下界

object demo {

  def example() = {
    //    trait Node[+B] {
    //      def prepend[U >: B](elem: U): Node[U]
    //    }
    //
    //    case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
    //      def prepend[U >: B](elem: U): ListNode[U] = ListNode(elem, this)
    //
    //      def head: B = h
    //
    //      def tail: Node[B] = t
    //    }
    //
    //    case class Nil[+B]() extends Node[B] {
    //      def prepend[U >: B](elem: U): ListNode[U] = ListNode(elem, this)
    //    }
    //
    //
    //    trait Bird
    //    case class AfricanSwallow() extends Bird
    //    case class EuropeanSwallow() extends Bird
    //
    //
    //    val africanSwallowList = ListNode[AfricanSwallow](AfricanSwallow(), Nil())
    //    val birdList: Node[Bird] = africanSwallowList
    //    birdList.prepend(new EuropeanSwallow)
  }

  example()

}
