package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def aFactorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n)
      val result = n * aFactorial(n - 1)
      result
    }
  }
println(aFactorial(5))
  // if we call aFactorial of 5000, it would cause a StackOverflow Error = recursive depth is too big

  def anotherFactorial (n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator) //TAIL RECURSION
    }
    factorialHelper(n, 1)
  }
    // anotherFactorial wouldn't crash at 5000. Why? Because it's tail recursive!

  // Exercises
  //1. concatenate a string n times
  def stringConcat(word: String, n: Int): String = {
    @tailrec
    def concatHelper(x: Int, accumulator: String): String = {
      if (x <= 1) accumulator
      else concatHelper(x - 1, word + accumulator)
    }
    concatHelper(n, word)
  }
  println(stringConcat("hi ", 3))

  //2. is prime
  def isPrime (n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(x: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (x <= 1) true
      else isPrimeUntil(x - 1, n % x != 0)
    }
    isPrimeUntil(n - 1, true)
  }

  println(isPrime(7))

//3. Fibonacci
  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciHelper (i: Int, acc1: Int, acc2: Int): Int = {
      if (i >= n) acc1
      else fibonacciHelper(i + 1, acc1 + acc2, acc1)
    }
    if (n <= 2) 1
    else fibonacciHelper(2, 1, 1)
  }

}
