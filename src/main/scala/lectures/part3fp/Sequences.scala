package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  val aSequence = Seq(1,2,3,4)
  // have well-defined order
  //can be indexed
  println(aSequence) // List(1,2,3,4)
  println(aSequence.reverse)
  println(aSequence(2)) // 3
  println(aSequence ++ Seq(5,6,7)) // appending
  println(aSequence.sorted) // good for numerical types

  // Ranges
  val aRange: Seq[Int] = 1 to 10 // 1 until 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  //Lists
  val aList = List(1,2,3)
  val prepended = 42 +: aList // synt sugar for ::.apply(prepended)
  println(prepended)
  val appended = aList :+ 89

  val apples5 = List.fill(5)("apple") // curried function
  println(apples5)

  println(aList.mkString("-|-"))

  // arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3) // String == null
  threeElements.foreach(println)

  // mutation of arrays
  numbers(2) = 0 // changes item at index 2 to 0
  // syntax sugar for numbers.update (2, 0)
  println(numbers.mkString(" "))

  // arrays and sequences
  val numbersSeq: Seq[Int] = numbers // an implicit conversion
  println(numbersSeq)

  // vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vectors VS lists

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      iteration <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), 0)
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))
}
