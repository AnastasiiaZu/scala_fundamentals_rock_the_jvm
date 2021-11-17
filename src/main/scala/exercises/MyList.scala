package exercises


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

   // functional part HOFs
   def foreach (f: A => Unit): Unit
   def sort (compare: (A, A) => Int): MyList[A]
   def zipWith[B, C] (list: MyList[B], zip: (A, B) => C): MyList[C]
   def fold[B] (start: B)(operator: (B, A) => B): B

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

  //HOFs
  override def foreach(f: Nothing => Unit): Unit = ()
  override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = EmptyList

  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else EmptyList

  override def fold[B](start: B)(operator: (B, Nothing) => B): B = start
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

  // HOFs
  override def foreach(f: A => Unit): Unit = {
    f(h)
    tail.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) Cons(x, EmptyList)
      else if (compare(x, sortedList.head) <=0) Cons(x, sortedList)
      else Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] =
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Cons (zip(h, list.head), t.zipWith(list.tail, zip))

  override def fold[B](start: B)(operator: (B, A) => B): B = {
    val newStart = operator(start, h)
    t.fold(newStart)(operator)
  }
}

object ListTest extends App {
  val listOfIntegers = new Cons(1, new Cons(2, new Cons (3, EmptyList)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons (5, EmptyList))
  val listOfStrings: MyList[String] = new Cons("Hello ", new Cons ("Scala!", EmptyList))

  println(listOfIntegers.toString)

  println(listOfIntegers.map(_ * 2).toString)
  println(listOfIntegers.filter(_ % 2 == 0).toString)
  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem + 1, EmptyList))).toString)


}




