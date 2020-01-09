//package channel_1.类型上界
//
//object demo {
//
//  abstract class Animal {
//    def name: String
//  }
//
//  abstract class Pet extends Animal {}
//
//  class Cat extends Pet {
//    override def name: String = "Cat"
//  }
//
//  class Dog extends Pet {
//    override def name: String = "Dog"
//  }
//
//  class Lion extends Animal {
//    override def name: String = "Lion"
//  }
//
//  class PetContainer[P <: Pet](p: P) {
//    def pet: P = p
//  }
//
//  def simple_example(): Unit = {
//    //类PetContainer接受一个必须是Pet子类的类型参数P。因为Dog和Cat都是Pet的子类，所以可以构造PetContainer[Dog]和PetContainer[Cat]。但在尝试构造PetContainer[Lion]的时候会得到下面的错误信息：
//    //type arguments [Lion] do not conform to class PetContainer's type parameter bounds [P <: Pet]
//    //这是因为Lion并不是Pet的子类。
//    val dogContainer = new PetContainer[Dog](new Dog)
//    val catContainer = new PetContainer[Cat](new Cat)
//    // this would not compile
//    val lionContainer = new PetContainer[Lion](new Lion)
//  }
//
//
//  def main(args: Array[String]): Unit = {
//    simple_example()
//  }
//}
