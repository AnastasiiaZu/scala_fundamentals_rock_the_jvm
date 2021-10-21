package lectures.part1basics

object TypeInference extends App {

  val message = "Hello world" // The compiler knows it's a String type

  val x = 2
  val y = x + "items" // so y is also a String type as Int + String = String

  // return type of the function
  def next (x: Int) = x + 1 //Int

  // return type needs to be specified in a recursive function

}
