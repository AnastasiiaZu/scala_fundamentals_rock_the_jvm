package lectures.part3fp

import scala.annotation.tailrec

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
  println(List(("Lola", 555)).toMap)

  val names = List("Jim", "Ana", "Angela", "Mary", "James", "Matt")
  println(names.groupBy(name => name.charAt(0)))

//  Exercises

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]],a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }
    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Mary"), "Bob")
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  //Jim, Bob, Mary
  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet)) // Bob

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int = {
    network.view.filterKeys(k => network(k).isEmpty).size
    // network.count(pair => pair._2.isEmpty) - equivalent
  }

  println(nPeopleWithNoFriends(testNet)) // 0

  def socialConnection(network: Map[String, Set[String]],a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs (target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }
    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet, "Mary", "Jim")) // true
  println(socialConnection(network, "Mary", "Bob")) // false
}
