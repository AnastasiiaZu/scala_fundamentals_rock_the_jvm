package exercises

import scala.collection.immutable.TreeSeqMap.Empty
 abstract class MyList [+A] {

  def head: A
  def tail: MyList [A]
  def isEmpty: Boolean
  def add [B >: A](newElem: B): MyList[B]
  def printElements: String
  //polymorphic method
  override def toString: String = "[" + printElements + "]"

   //higher order functions
  def map[B] (transformer: A => B): MyList[B]
  def flatMap[B] (transformer: A => MyList[B]): MyList[B]
  def filter(condition: A => Boolean): MyList[A]
  // concatenation
  def ++ [B >: A] (list: MyList[B]): MyList[B]
}

case object EmptyList extends MyList [Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add [B >: Nothing] (newElem: B): MyList[B] = new Cons (newElem, EmptyList)
  def printElements: String = ""

  def map[B] (transformer: Nothing => B): MyList[B] = EmptyList
  def flatMap[B] (transformer: Nothing => MyList[B]): MyList[B] = EmptyList
  def filter(condition: Nothing => Boolean): MyList[Nothing] = EmptyList

  def ++ [B >: Nothing] (list: MyList[B]): MyList[B] = list
}

case class Cons [+A] (h: A, t: MyList[A]) extends MyList [A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add [B >: A](newElem: B): MyList[B] = new Cons (newElem, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  def map[B] (transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  def filter(condition: A => Boolean): MyList[A] =
    if (condition(h)) new Cons(h, t.filter(condition))
    else t.filter(condition)

  def ++ [B >: A] (list: MyList[B]): MyList[B] = new Cons (h, t ++ list)

  def flatMap[B] (transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)
}

object ListTest extends App {
  val list1 = new Cons(1, new Cons(2, new Cons (3, EmptyList)))

  println(list1.toString)
}




