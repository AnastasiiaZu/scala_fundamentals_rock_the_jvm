package lectures.p4pm

object BracelessSyntax  extends App {

  // if-expression - scala 2
  val anIfExpression =
    if (2 > 3) "bigger"
    else "smaller"

  // scala 3
  val anIfExpression_scala3 =
    if 2 > 3 then
      "bigger"
    else
      "smaller" // python-style

  //for-comprehensions - scala 3
  val aForComprehension =
    for
      n <- List(1,2,3)
      s <- List("black", "white")
   yield s"$n$s"

  //pattern matching - scala 3
  val meaningOfLife = 42
  val aPatternMatch =
    meaningOfLife match
      case 1 => "1"
      case _ => "something else"

  // methods without braces - scala 3
  def computeMeaningOfLife(arg: Int): Int =
    val partialResult = 40
    partialResult + 2

  // classes, enums, objects, traits, etc - scala 3
  class Animal:
    def eat(): Unit =
      println("I'm eating")

    def grow(): Unit =
      println("I'm growing")
  end Animal // can add 'end' anywhere


}
