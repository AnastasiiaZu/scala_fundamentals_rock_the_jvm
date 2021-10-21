package lectures.part1basics

object StringOps extends App {

 val str: String = "Hello, I'm learning Scala"

 // Java methods
 println(str.charAt(2))
 println(str.substring(7, 11))
 println(str.split(" ").toList)
 println(str.startsWith("Hello")) // returns true
 println(str.replace(" ", "-"))
 println(str.toLowerCase()) // all lower or Upper case
 println(str.length) // returns 26, can be invoked without ()

 // Scala methods
 val aNumberString = "42"
 val aNumber = aNumberString.toInt // 45
 println('a' +: aNumberString :+ 'z') //pre-pending +: and app-pending :+
 println(str.reverse)
 println(str.take(2)) // returns He

 // S-interpolators
 val name = "Anastasiia"
 val age = 27
 val greeting = s"Hello, my name is $name amd I am $age y.o."
 val anotherGreeting = s"Hello, my name is $name amd I will bw turning ${age + 1} y.o." // injecting values inside a string

 // F-interpolators
 val speed = 1.2f
 val myth = f"$name can eat $speed%2.2f veggie burgers per minute" // at least 2 characters and 2 precision after the dot
 println(myth)

 // raw-interpolator
 val escaped = "This is a \n newline"
 println(raw"$escaped") // backslashes will net be escaped


}
