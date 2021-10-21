package lectures.part2op

import scala.language.postfixOps

object Sugar extends App {

  class Person (val name: String, favMovie: String, val age: Int = 0) {

    def likes (movie: String): Boolean = movie == favMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with $person.name"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and my fav movie is $favMovie, and I am $age y.o."
    //exercises
    def + (nickname: String): Person = new Person(s"$name ($nickname)", favMovie, age)
    def unary_+ : Person = new Person(name, favMovie, age + 1)
    def learns(what: String): String = s"$name learns $what"
    def learnsScala: String = learns("Scala")
    def apply(times: Int) = s"$name watched $favMovie $times times"
  }
 // infix notation
  val mary = new Person ("Mary", "Inception", 24)
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation == object method param -> for classes with only one method = syntactic sugar

  val tom = new Person ("Tom", "Fight Club", 36)

  println(mary hangOutWith tom) // infix notation can be used for method with single param
  println(mary.hangOutWith(tom)) // equivalent

  //ALL OPERATORS ARE METHODS
  val addition = 1 + 2
  val addition1 = 1.+(2) //equivalent

  // prefix notation
  val x = - 1
  val y = 1.unary_- // equivalent
 // unary works with + - ~ !

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive) // equivalent. only available for methods without parameters

  // apply
  println(mary.apply())
  println(mary()) // equivalent. when an object is called like a function it looks for the apply method
  // it breaks the barrier between the OO programming and the FP programming

  // 1. overload a + infix operator mary + "the rockstar" => new person "Mary (the rockstar)
 println((mary + "the rockstar").apply())

  // 2. add age to the person class
  println((+mary).apply())

  // 3. add 'learns' method
  println(tom.learns("Java"))
  println(tom learnsScala)

  // 4. overload the apply method  mary.apply(2) -> mary watched Inception 2 times
  println(tom.apply(3))
}
