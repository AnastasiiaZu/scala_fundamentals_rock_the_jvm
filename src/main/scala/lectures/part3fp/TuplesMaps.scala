package lectures.part3fp

object TuplesMaps extends App {

  // tuples = finite ordered 'lists'
  // cal group 22 elements of different types
  val aTuple = Tuple2(2, "hello, Scala!") //Tuple2[Int, String] = (Int, String)

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "goodbye, Java!"))
  println(aTuple.swap) // swaps the elements in place

  // Maps - associate keys to values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 3445), ("Nina", 5647)) // specifying pairings
  // OR
  val anotherPhoneBook = Map("Daniel" -> 9907, "Anna" -> 9874).withDefaultValue(0) // otherwise throws a NoSuchElementException
  println(anotherPhoneBook)

  // Maps ops
  println(phonebook.contains("Jim")) // true
  println(phonebook("Jim")) // 3445

  // add a pairing
  val newPairing = "Mary" -> 345
  val newPhoneBook = phonebook + newPairing
  println(newPhoneBook)

  // functionals on Maps
  // map, flatmap, filter

  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phonebook.view.filterKeys(x => x.startsWith("J")).toMap)

  // mapValues
  println(phonebook.view.mapValues(number => number * 10).toMap)

  // conversion to other collection
  println(phonebook.toList)
  println(List(("Nastia", 555)).toMap)

  val names = List("Jim", "Ana", "Angela", "Mary", "James", "Matt")
  println(names.groupBy(name => name.charAt(0)))


}
