package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)
  // vals can't be reassigned == are IMMUTABLE

  val y = 34
  // compiler can infer a type without spesifying it explicitly

  val aString: String = "This is a string"

  //Basic types
  val aBoolean: Boolean = true // or false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aFloat: Float = 2.0f
  val aDouble: Double = 1.72

  //Variables
  var aVariable: Int = 4

  aVariable = 5 // variables can be reassign
  // have side effects == allow to see what programs are doing (like println) or reassigning a variable
  // we need side effects as we want the program to do something to the outside world
}

