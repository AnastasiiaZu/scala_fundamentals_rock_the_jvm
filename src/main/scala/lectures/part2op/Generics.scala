package lectures.part2op

object Generics extends App {

  // A - a generic type
  class MyList[+A] { // <- actually an invariant list
    // use the type A inside the class definition
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Animal
    */

  }

  class MyMap[Key, Map] // both Key and Value are generic types. It also works for traits


  // reusable code
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ??? // returns nothing
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  // 1. if Cat extends Animal, does the List[Cat] extend List[Animal]?
  // -> YES = COVARIANCE
  class Human
  class Animal extends Human
  class Cat extends Animal
  class Dog extends Animal

  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // animalList.add(new Dog) can I add animals to it? HARD QUESTION => we return a list of animals
  // a Dog would pollute a List[Cat] - and turn it into a more generic List[Animal]

  // 2. NO = INVARIANCE
  // can't substitute one for another
  class InvariantList [A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. HELL, NO! = CONTRAVARIANCE
  // opposite relation to covariance
  class Trainer[-A]
  val contravariantListTrainer: Trainer[Cat] = new Trainer[Animal] // Trainer of Animals can also train a cat

  // bounded types
  // 1. Upper bounded type
  class Cage[A <: Animal] (animal: A)// class Cage only accepts subtypes of Animal
  val cage = new Cage(new Dog)

  class Car
  val newCage = new Cage(new Car) // <- compile error

  // 2. lower bounded type
  class Owner[A >: Animal](owner: A)
  val Rob = new Owner(new Human)
}
