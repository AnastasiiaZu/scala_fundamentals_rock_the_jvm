package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 //Expression - evaluated to a value
  println(x) //gives 3

  //most expressions are mostly math expressions


  println(1 == x) // returns false

  // relational operations
  // == ! = > >= < <=

  //also logical operands like OR AND NOT  ! && ||
  println(!(1 == x))

  // adding to the variable
  var aVariable = 2
  aVariable += 3 // gives 5, also works with -= *= /= ... these are side effects

  // Instructions (DO) VS Expressions (VALUE)

  // IF Expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  // IF Expr evaluates to a value, and isn't an instruction to assign a value
  print(aConditionedValue) // gives 5

  // LOOPS are discouraged in Scala!
  // While is specific to imperative programming and we don't do this
  // Everything in Scala is an Expression!

  val aWeirdValue = (aVariable = 3) //gives a Unit === void

  //side effects: println(), whiles, reassigning - all the reminiscent of imperative programming
  //all side effects return a value type Unit

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "bye"
  }
  // A Code block is an expression. The value of the Code block is the value of it's last expression
  // Can have their own definitions of values and expressions, and those are only visible inside of the Code block
}
