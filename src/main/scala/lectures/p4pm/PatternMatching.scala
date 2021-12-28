package lectures.p4pm

import scala.util.Random

object PatternMatching extends App {

  // switch on steroids
  val random = new Random()
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the one"
    case 2 => "double or nothing"
    case 3 => "third one is the charm"
    case _ => "anything else" // = Wildcard
  }

  println(x)
  println(description)

  // 1. decompose values - good with Case Classes
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I can't drink in the US"
    case Person(n, a) => s"Hi, my name is $n and I am $a y.o."
    case _ => "I don't know who I am"
  }

  println(greeting)

  /*
  1. cases are matched in order
  2. if no cases match? -> scala.MatchError
  3. type of PM expression is the unification of all cases (lowest common ancestor)
  4. PM works really well with case classes
  */

  // PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Collie")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }

  // the urge to match everything!
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  } // WHY?!

  val isEvenNormal: Boolean = x % 2 == 0

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show (e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) =>
      def showParenthesis(exp: Expr) = exp match {
        case Prod(_ , _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }
      showParenthesis(e1) + " * " + showParenthesis(e2)
  }

println(show(Prod(Sum(Number(3), Number(5)), Sum(Number(4), Number(2)))))
}
