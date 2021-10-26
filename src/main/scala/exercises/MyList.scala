package exercises

import scala.collection.immutable.TreeSeqMap.Empty

abstract class MyList {

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(newElem: Int): MyList
  def printElements: String
  //polymorphic method
  override def toString: String = "[" + printElements + "]"
}

object EmptyList extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(newElem: Int): MyList = new Cons (newElem, EmptyList)
  def printElements: String = ""
}

class Cons (h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(newElem: Int): MyList = new Cons (newElem, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {
  val list1 = new Cons(1, new Cons(2, new Cons (3, EmptyList)))

  println(list1.toString)
}
  /*
  def head = first element
  def tail = remainder of the list
  isEmpty = boolean
  add(int) returns a new list with the elem added
  override toString which returns a string implementation
  */


