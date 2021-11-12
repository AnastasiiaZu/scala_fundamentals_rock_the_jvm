package lectures.part2op

object Exceptions extends App {

val x: String = null
//println(x.length) // throws a Null Pointer Exception

// 1. we can throw exceptions

// this crushes a program, it's an expression
//val aWeirdValue = throw new NullPointerException // returns Nothing

// Exceptions are instances of Classes - hence the 'new' keyword
// -->> extends the Throwable class
// Exception and Error are major Throwable subtypes

// 2. catch exceptions
def getInt(withException: Boolean): Int =
  if (withException) throw new RuntimeException("No int for you")
  else 42

try {
  // code that might fail
  getInt(true)
} catch {
  // which error we are catching
  case e: RuntimeException => println("Caught a runtime exception")
} finally {
  // will get executed no matter what
  // optional
  // does not influence the return type of the expression
  // use finally only for side effects
  println("finally")
}

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  // throw exception

  /*//Exercises
  1. Crash program with OutOfMemoryError
  2. Crash with SOError - like in recursion
  3. PocketCalculator
        - add
        - subtract
        - multiply
        - divide
   */
// OOM
  //val array = Array.ofDim(Int.MaxValue) // OutOfMemoryError

  // SO
  def infinite: Int = 1 + infinite
  val noLimit = infinite

  class OverflowException extends Exception
  class UnderFlowException extends Exception
  class MathCalcException extends Exception

 object PocketCalculator {
  def add(x: Int, y: Int): Int = {
    val result = x + y
    if (x > 0 && y > 0 && result < 0) throw new OverflowException
    else if (x < 0 && y < 0 && result > 0) throw new UnderFlowException
    else result
  }

   def subtract(x: Int, y: Int): Int = {
     val result = x - y
     if (x > 0 && y < 0 && result < 0) throw new OverflowException
     else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
     else result
   }

   def multiply(x: Int, y: Int): Int = {
     val result = x * y
     if (x > 0 && y > 0 && result < 0) throw new OverflowException
     else if (x < 0 && y > 0 && result > 0) throw new OverflowException
     else if (x > 0 && y < 0 && result < 0) throw new UnderFlowException
     else result
   }

  def divide(x: Int, y: Int): Int = {
    val result = x / y
    if (y == 0) throw new MathCalcException
    else result
  }
}



}
