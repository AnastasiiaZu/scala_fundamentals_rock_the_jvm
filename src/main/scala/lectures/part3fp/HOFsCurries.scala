package lectures.part3fp

object HOFsCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null // == HOF

  // Higher Order Functions (HOF)
  // map, flatmap, filter in MyList

  // function that applies a fn n times over a given value x
  // nTimes(f, n, x)
  //nTimes(f, 3, x) = f(f(f(x))) -> classical example of a HOF

  //functional programming derives from abstract math :)
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1)) // 11

  // ntb(f, n) = x => f(f(f...(x))) -> it returns a lambda
  // increment10 = ntb(plusOne, 10) = x => plusOne(plusOne...(x))
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n<=0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1)) // 11

  // Curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y
  println(add3(10)) // 13
  println(superAdder(3)(10)) //equivalent - superAdded takes two parameter lists

  // functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  //partial application
  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%1.8f") // 8 digits after comma
  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  // Exercises
  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x, y)

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
    (x, y) => f(x)(y)

  //FunctionX - compose and andThen are available there
  def compose(f: Int => Int, g: Int => Int): Int => Int =
    x => f(g(x))

  def andThen(f: Int => Int, g: Int => Int): Int => Int =
    x => g(f(x))

  //generic versions
  def composeGeneric[A, B, T](f: A => B, g: T => A): T => B = //applies g first, then f
    x => f(g(x))

  def andThenGeneric[A, B, C](f: A => B, g: B => C): A => C = // applies f first, then g
    x => g(f(x))

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)
  def add4: Int => Int = superAdder2(4)
  println(add4(21)) // 25

  val simpleAdder = fromCurry(superAdder)
  println(simpleAdder(4, 17)) // 21

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println(composed(4)) // 14
  println(ordered(4)) // 18
}
