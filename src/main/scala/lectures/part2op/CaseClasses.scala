package lectures.part2op

object CaseClasses extends App {

  // equals, hashCode, toString
  // case class is code for defining a Class and a companion Object in one go
  case class Person(name: String, age: Int)

  // 1. class params are promoted to fields
  val jim = new Person("Jim", 27)
  println(jim.name)

  // 2. sensible toString
  println(jim.toString) // Person(Jim, 27)
  println(jim) // == println(jim.toString) <- syntactic sugar

  // 3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 27)
  println(jim == jim2) // true

  //4. CC have handy copy methods
  val jim3 = jim.copy(age = 45) // creates a new instance of this CC

  // 5. CCs have companion o jects
  val thePerson = Person
  val mary = Person("Mary", 26) // delegates to the apply method, the keyword NEW isn't needed

  //6. CCs are serializable
  // Akka deals with serializable messages which are CCs

  // 7. CCs have extractor pattern -> can be used in pattern matching

  case object UnightedKingdom { // acs like a CC + it's own object
    def name: String = "The UK of Gb and NI"
  }


}
