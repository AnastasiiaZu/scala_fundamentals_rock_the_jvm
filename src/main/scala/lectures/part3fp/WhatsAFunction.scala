package lectures.part3fp

import lectures.part1basics.Expressions.x

object WhatsAFunction extends App{

  // use functions as first-class elements == work with functions like with plain values
  // e.g. pass functions as params or return functions as a result
  // problem: oop
  // -> it makes everything an instance of a class

  //e.g.
  val doubler = new MyFunction[Int, Int] {
    override def apply(elem: Int): Int = elem * 2
  }

  println(doubler(2)) // calls the apply method

  trait MyFunction [A, B] {
    def apply(elem: A): B
  }

  // function types = Function1[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4) // 7

  // Scala supports up to 22 params in Functions
  // Function2[String, String, Int] - the first two are the input type, the lats one is the output type
  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  val sugarAdder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function Type
  //(A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS -> instances of classes deriving from Function1, 2, etc
  // JVM wasn't designed for functional implementation, it was designed for OOP
  // Scala achieves true functionality via a bunch of syntactic sugar

  // 1.
  val concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + " " + b

  }

  println(concatenator("LaLa", "Land"))

// 3.
 val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
   override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
     override def apply(y: Int): Int = y + x
   }
 }

  val adder3 = superAdder(3)
  println(adder3(4)) // 7
  println(superAdder(3)(5)) // == curried function
}
