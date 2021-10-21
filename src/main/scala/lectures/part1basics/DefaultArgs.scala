package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def tailrecFactorial(n: Int, acc: Int): Int = {
    if (n <= 1) acc
    else tailrecFactorial(n - 1, n * acc)
  }
  val fact10 = tailrecFactorial(10, 1) // the second value pollutes the function signature

  // DEFAULT PARAM acc: Int = 1
  @tailrec
  def tailrecFactorialWithDefault (n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else tailrecFactorialWithDefault (n - 1, n * acc)
  }

  val fact11 = tailrecFactorialWithDefault(11) // acc is implied as 1. Default value can be overwritten
  val fact12 = tailrecFactorialWithDefault(12, acc = 2)
}
