package lectures.part3fp

import scala.List

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + "is a number"))

  // filter
  println(list.filter(_ % 2 == 0)) // condition should return true to pass

  // flatmap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // Exercise// print all combinations between two lists
  // a1, a2, ... d4
  // this is how "iterations" are done
  val numbers = List(1,2,3,4)
  val characters = List("a","b","c","d")

  val combinations = numbers.flatMap(n => characters.map(c => c + n)) // instead of loops
  println(combinations)

  val colors = List("blue", "green")
  val colorNumberCharCombinator = numbers.flatMap(n => characters.flatMap(c => colors.map(color => c + n + "-" + color)))
  println(colorNumberCharCombinator)

  // forEach
  list.foreach(println)

  //shorthand fo the nested flatMaps / maps is the // for-comprehension
  val forCombinator = for {
    n <- numbers
    c <- characters
    color <- colors
  } yield c + n + "-" + color

  println(forCombinator) // equivalent to println(colorNumberCharCombinator)

  // filter + for-comprehension
  val forCombinatorWithFilter = for {
    n <- numbers if n % 2 == 0 // <- adds a filter on top
    c <- characters
    color <- colors
  } yield c + n + "-" + color

  // syntax overload - same functionality
  list.map { x =>
    x * 2
  }

}


