package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  // Functions are expressions
  def aFunction(a: String, b: Int): String = { // function signature
    a + " " + b
  }

  println(aFunction("hello", 3)) // gives hello 3

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction()) //accessed as parameterless by the compiler

  //Functions instead of loops
  def aRepeatedFunction(aString: String, n: Int): String = { // a recursive function - it calls itself
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))

  // Recursive functions are used as loops!
  // The worst thing a Scala coder can do is using imperative code with Scala syntax

  // Return type of a normal function can be inferred by a compiler by looking at the implementation
  def anotherFunction(a: Int, b: Int) = a * b

  // A recursive function NEEDS a return type
  // Can use Unit as a return type - that it returns a side effect
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  // A Code block allows to define an internal function inside
  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b

    aSmallFunction(n, n-1)
  }

  // Exercises
  //1.
  def aGreetingFunction (name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old"
  }

  //2.
  def aFactorial(n: Int): Int = {
    if (n == 1) 1
    else n * aFactorial(n - 1)
  }

  //3.
  def aFibonacciFunction(n: Int): Int = {
    if (n <= 2) 1
    else aFibonacciFunction(n - 1) + aFibonacciFunction(n - 2)
  }

  println(aFibonacciFunction(6)) // gives 8

  //4.
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n - 1)
  }

}