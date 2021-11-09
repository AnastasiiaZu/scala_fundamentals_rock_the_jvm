package lectures.part2op

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  // compiler actually creates a new anon class and then the val instantiates that one
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahaha")
  }

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name")
  }

  val jim = new Person ("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I help")
  }
}
