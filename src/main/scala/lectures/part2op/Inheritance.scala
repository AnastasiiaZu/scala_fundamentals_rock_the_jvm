package lectures.part2op

object Inheritance extends App {

  // functions are Private, Protected, or Public (default)
  class Animal {
    def eat: Unit = println("nom nom nom!")
    private def poop(): Unit = println("ke ke ke!") // private fields are only accessible in this class, not it's subclasses or outside
    // protected def - usable within this class ans it's subclasses
    protected def sound(): Unit = println("Sound!")
    val creatureType = "a wild"
    final def beGood = true // cannot be overridden
  }

  // extending the class means inheriting all the non-private fields
  // Cat = subclass of Animal, Animal is Superclass to Cat
  class Cat extends Animal {
    def meow(): Unit = {
      sound()
      println("Meow!") // overrides the inherited method
    }
  }

  val cat = new Cat
  cat.eat // prints nom nom nom!
  cat.meow() // prints Meow!

  // constructors
  class Person (name: String, age: Int)
  class Adult (name: String, age: Int, idCard: String) extends Person (name, age) // to extend need to specify the params

  // overriding
  //  all instances of classes will use overridden definitions

  class Dog (override val creatureType: String) extends Animal {
     override def eat: Unit = {
       super.eat
       println("Crunch crunch")
     }
     // can be a class param as well
    // override val creatureType = "domestic"
  }
  val dog = new Dog("canine")
  dog.eat // prints Crunch crunch
  println(dog.creatureType) // prints canine

  class Horse (horseType: String) extends Animal {
    override val creatureType: String = horseType // the same as passing it to the param
  }

  // type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("collie")
  unknownAnimal.eat // uses Dog's method

  // overRIDING = supplying new implementation in derived classes VS overLOADING = supplying multiple methods with the same name but different signatures

  // preventing overrides
  // 1. use final keyword before def/val to prevent overriding or 2. class - to prevent class extensions
  // 3. seal the class = can extend classes in THIS FILE, but prevents extension in other files

}
