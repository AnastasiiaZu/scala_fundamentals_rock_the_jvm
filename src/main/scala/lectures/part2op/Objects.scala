package lectures.part2op

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")

  // Companions - Class + Object with the same name

  object Person { // type + only instance
    // Object is SINGLETON (== one instance of it)
    // Object can be defines as classes, except they don't receive parameters
    // Separates "static" / "class" - level functionality

    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply (mother: Person, father: Person): Person = new Person("Bobby")

  }

  class Person (val name: String) {
    // instance-level functionality
    // Class can create multiple instances (== non SINGLETON)

  }

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val mary = Person
  val john = Person
  println(mary == john) // gives true

  val person1 = new Person("Mary")
  val person2 = new Person("John")
  println(person1 == person2) // gives false - they are 2 distinct instances

  // factory method
  val bobby = Person(person1, person2) // using apply here
  println(bobby.name)

  // Scala Applications = Scala Object with
  // def main(args: Array[String]): Unit
  // or extends App which already has a def main implemented
}
