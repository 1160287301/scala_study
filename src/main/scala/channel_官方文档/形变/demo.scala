package channel_官方文档.形变

object demo {

  abstract class Animal {
    def name: String
  }

  case class Cat(name: String) extends Animal

  case class Dog(name: String) extends Animal

  def covariant(): Unit = {
    //使用注释 +A，可以使一个泛型类的类型参数 A 成为协变。
    //对于某些类 class List[+A]，使 A 成为协变意味着对于两种类型 A 和 B，
    //如果 A 是 B 的子类型，那么 List[A] 就是 List[B] 的子类型。
    //这允许我们使用泛型来创建非常有用和直观的子类型关系。


    def printAnimalNames(animals: List[Animal]): Unit = {
      animals.foreach { animal =>
        println(animal.name)
      }
    }

    val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
    val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

    printAnimalNames(cats)
    printAnimalNames(dogs)
  }

  def contravariant(): Unit = {
    //通过使用注释 -A，可以使一个泛型类的类型参数 A 成为逆变。
    //与协变类似，这会在类及其类型参数之间创建一个子类型关系，但其作用与协变完全相反。
    //也就是说，对于某个类 class Writer[-A] ，使 A 逆变意味着对于两种类型 A 和 B，
    //如果 A 是 B 的子类型，那么 Writer[B] 是 Writer[A] 的子类型。
    abstract class Printer[-A] {
      def print(value: A): Unit
    }

    class AnimalPrinter extends Printer[Animal] {
      def print(animal: Animal): Unit =
        println("The animal's name is: " + animal.name)
    }

    class CatPrinter extends Printer[Cat] {
      def print(cat: Cat): Unit =
        println("The cat's name is: " + cat.name)
    }

    val myCat: Cat = Cat("Boots")

    def printMyCat(printer: Printer[Cat]): Unit = {
      printer.print(myCat)
    }

    val catPrinter: Printer[Cat] = new CatPrinter
    val animalPrinter: Printer[Animal] = new AnimalPrinter

    printMyCat(catPrinter)
    printMyCat(animalPrinter)

  }

  def invariant(): Unit = {
    // 默认情况下，Scala中的泛型类是不变的。
    // 这意味着它们既不是协变的也不是逆变的。
    // 在下例中，channel_1.类 Container 是不变的。
    // Container[Cat] 不是 Container[Animal]，反之亦然。
    class Container[A](value: A) {
      private var _value: A = value

      def getValue: A = _value

      def setValue(value: A): Unit = {
        _value = value
      }
    }
    // 可能看起来一个 Container[Cat] 自然也应该是一个 Container[Animal]，
    // 但允许一个可变的泛型类成为协变并不安全。 在这个例子中，Container 是不变的非常重要。
    // 假设 Container 实际上是协变的，下面的情况可能会发生
    // val catContainer: Container[Cat] = new Container(Cat("Felix"))
    // val animalContainer: Container[Animal] = catContainer  // Expression of type Container[demo.Cat] doesn't conform to expected type Container[demo.Animal]
    // animalContainer.setValue(Dog("Spot"))
    // val cat: Cat = catContainer.getValue // 糟糕，我们最终会将一只狗作为值分配给一只猫  幸运的是，编译器在此之前就会阻止我们。

  }


  def main(args: Array[String]): Unit = {
    //    covariant() // 协变
    //    contravariant() // 逆变
    invariant() //不变
  }

}
