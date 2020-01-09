package channel_官方文档.内部类

object demo {

  def example() = {
    class Graph {
      class Node {
        var connectedNodes: List[Node] = Nil
        def connectTo(node: Node) {
          if (connectedNodes.find(node.equals).isEmpty) {
            connectedNodes = node :: connectedNodes
          }
        }
      }
      var nodes: List[Node] = Nil
      def newNode: Node = {
        val res = new Node
        nodes = res :: nodes
        res
      }
    }

    //如果我们现在有两个图形，Scala 的类型系统不允许我们将一个图形中定义的节点与另一个图形的节点混合，
    // 因为另一个图形的节点具有不同的类型。
    // 下例是一个非法的程序
    val graph1: Graph = new Graph
    val node1: graph1.Node = graph1.newNode
    val node2: graph1.Node = graph1.newNode
    node1.connectTo(node2)      // legal
    val graph2: Graph = new Graph
    val node3: graph2.Node = graph2.newNode
//    node1.connectTo(node3)      // illegal!
  }

  def example1(): Unit = {
    //类型 graph1.Node 与类型 graph2.Node 完全不同。
    // 在 Java 中，上一个示例程序中的最后一行是正确的。
    // 对于两个图形的节点，Java 将分配相同的类型 Graph.Node; 即 Node 以类 Graph 为前缀。 在Scala中也可以表示出这种类型，它写成了 Graph#Node。 如果我们希望能够连接不同图形的节点，
    // 我们必须通过以下方式更改图形类的初始实现的定义：
    class Graph {
      class Node {
        var connectedNodes: List[Graph#Node] = Nil
        def connectTo(node: Graph#Node) {
          if (connectedNodes.find(node.equals).isEmpty) {
            connectedNodes = node :: connectedNodes
          }
        }
      }
      var nodes: List[Node] = Nil
      def newNode: Node = {
        val res = new Node
        nodes = res :: nodes
        res
      }
    }
    val graph1: Graph = new Graph
    val node1: graph1.Node = graph1.newNode
    val node2: graph1.Node = graph1.newNode
    node1.connectTo(node2)      // legal
    val graph2: Graph = new Graph
    val node3: graph2.Node = graph2.newNode
    node1.connectTo(node3)      // legal!

  }

  def main(args: Array[String]): Unit = {
    example()
    example1()
  }
}
