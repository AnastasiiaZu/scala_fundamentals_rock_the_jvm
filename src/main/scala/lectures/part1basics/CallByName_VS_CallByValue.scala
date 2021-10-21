package lectures.part1basics

object CallByName_VS_CallByValue  extends App {

  def calledByValue(x: Long): Unit = {
    println("by value " + x)
    println("by value " + x)
  }

  // ERROR SYNTAX x: => Int
  def calledByName(x: => Long): Unit = {
    println("by name " + x) // gives different values here
    println("by name " + x) // gives different values here
  }

  calledByValue(System.nanoTime()) // the computer FIRST evaluates the value of System.nanoTime() and then PRINTS it twice
  calledByName(System.nanoTime()) // only evaluates the value of System.nanoTime() once it's called by println() => two different values
  // ByName is useful in lazy streams and try functions


}
