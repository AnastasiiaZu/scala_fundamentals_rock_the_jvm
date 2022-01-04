package lectures.part3fp

import exercises.{Cons, EmptyList, MyList}

object AllThePatterns extends App {

  // 1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"
  }

  // 2 - match anything
  // 2.1 wildcard

  val matchAnything = x match {
    case _ =>
  }

  // 2.2 variable
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1, 1) => "WOW"
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) => s"I found $v"
  }
  // PMs can be nested!

  // 4 - case classes - constructor pattern
  val aList: MyList[Int] = Cons(1, Cons(2, EmptyList))
  val matchAList = aList match {
    case EmptyList => "It's empty"
    case Cons(head, Cons(subhead, subtail)) => s"List($subhead, $subtail)"
  }

  // 5 - list patterns
  val aStandardList = List(1,2,3,42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => "this is an extractor" // advanced
    case List(1, _*) => "a list of arbitrary lenght" // advanced
    case 1 :: List(_) => "infix pattern" // a lot of magic here
    case List(1,2,3) :+ 42 => "also an infix pattern"
  }

  // 6 - type specifiers
  val unknown: Any = 2

  val unknownMatch = unknown match {
    case list: List[Int] => "explicit type specifier"
    case _ => "anything"
  }

  // 7 - name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) => "names a pattern = name binding" // use the name later (here)
    case Cons(1, rest @ Cons(2, _)) => "binding inside nested patterns"
  }

  // 8 - multi-patterns
  val multiPattern = aList match {
    case EmptyList | Cons(0, _) => "compound pattern (multi-pattern)"
  }

  // 9 - if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 => "filtering by the if guard"
  }

  ////////

  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "this is a list of strings"
    case listOfNumbers: List[Int] => "this is a list of numbers"
    case _ => "nothing"
  }

  println(numbersMatch) // would match the listOfStrings - since JVM is oblivious to generic types - it's called "type erasure"
}
