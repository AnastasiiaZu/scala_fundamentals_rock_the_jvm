package lectures.part2op

object AbstractDataTypes extends App {

  // Abstract methods and classes
  // Abstract classes cannot be instantiated -> they are made to be extended
  abstract class Animal {
    //unimplemented methods = abstract methods
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    //provide implementation on the abstract fields
    val creatureType: String = "Canine"
    def eat: Unit = println("Nom nom")
  }

  // traits
  //traits can be inherited among classes
  // can mix in as many traits as you want!
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "meat"
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"
    def eat: Unit = println("non non nom")
    def eat(animal: Animal): Unit = println(s"I'm a crocodile and I eat ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // difference traits VS abstract classes
  // abstract classes and traits can have both abstract and non-abstract methods
  // 1. traits don't have constructor params
  // 2. multiple traits may be inherited, but only one class
  // 3. traits are behaviour, abstract class is a type of thing
}
