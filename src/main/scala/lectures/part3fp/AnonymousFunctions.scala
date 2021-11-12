package lectures.part3fp

object AnonymousFunctions extends App {

  // the OO way of writing an anonymous function
  val doubler = new Function1[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }

  // the Scala way - anonymous function == LAMBDA
  val tripler: Int => Int = x => x * 3 // no need to announce separately the type of x
  // equivalent to val tripler = (x: Int) => x * 3

  // multiple params
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething) // doesn't work
  println(justDoSomething()) // <- how to call lambda

  // curly braces with lambdas
  val stringToInt = { (string: String) =>
    string.toInt
  }

  // MOAR syntactic sugar
  // val niceIncrementer: Int => Int = (x: Int) => x + 1
  val niceIncrementer: Int => Int = _ + 1 // equivalent

  // type annotations are essential
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  // 2.
  val sugarAdder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  val sugarAdderLambda: (Int, Int) => Int = _ + _

  // 2.1
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = y + x
    }
  }

  val superAdderLambda: Int => (Int => Int) = a => { b =>
    a + b
  }
  println(superAdderLambda(3)(6))
}
