package lectures.part2op

object OOBasics extends App {

  val person =  new Person ("Anton", 27)// creating an instance of a class
  println(person.age)
  println(person.x) // will also print 3 as it is in the class implementation
  person.greet("Nastia")

  val aWriter = new Writer ("Hermann", "Hesse", 1877)
  val aNovel = new Novel("Steppenwolf", 1923, aWriter)
  println(aNovel.authorsAgeAtRelease())

}

// Class organises data and behaviour
// instance - concrete realisation in memory that conform to the code and data structure that the class describes

class Person (name: String, val age: Int) { // == constructor // resembles how we pass params in a function
 // body
  val x = 2 // is a field, can be accessed by dot notation
  println(1 + 2)
  //also packages and classes

  // a method, can be accessed by dot notation
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  // this.name will refer to the name param of the construstor
  // this is usually implied, unless there's a method with the param with the same name

  // overloading = defining methods with the same name but different signatures (e.g. diff params)

  // multiple constructors:
  def this (name: String) = this(name, 0) // calls

}

// Class params are NOT FIELDS. Add val to the constructor makes it a field accessible by dot notation

// Exercises

class Novel (title: String, year: Int, author: Writer) {

  def authorsAgeAtRelease (birthYear: Int = author.year): String = "Author was " + (year - birthYear) + " years old at time of release"
  def isWrittenBy (who: Writer): Boolean = who == this.author // returns true if the referred writer is the same
  def copy (newReleaseDate: Int): Novel = new Novel (title, newReleaseDate, author)
}

class Writer (fName: String, sName: String, val year: Int) {

  def fullName: String = fName + " " + sName

}

class Counter (count: Int) {

  def currentCount: Int = count // or just use the val count: Int

  // immutability!!
  def increment = new Counter(count + 1)
  def decrement = new Counter(count - 1)
  //overloading
  def increment (amount: Int): Counter =  new Counter(count + amount)
  def decrement (amount: Int): Counter =  new Counter(count - amount)

}