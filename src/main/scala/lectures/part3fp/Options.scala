package lectures.part3fp

import scala.util.Random

object Options extends App {
  // wrapper for a value that might be absent
  // helps to avoid the null pointer
  // Some - concrete value
  // None - singleton for absent value
  // e.g. map.get method - returns Some or None

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(myFirstOption)

  // unsafe APIs
  def unsafeMethod(): String = null
//  val result = Some(null) // WRONG

  val result = Option(unsafeMethod()) // Some or None
  println(result) // == None

  // chained method
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod())) // alternative method

  // better DESIGN for unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBakUpMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBakUpMethod()

  // functions on Options
  println(myFirstOption.isEmpty) // == false
  println(myFirstOption.get) // UNSAFE

  // map, flatmap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // EXERCISE
  // for-comprehension
  val config: Map[String, String] = Map(
    // fetched from elsewhere - no certainty if host and port have values
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = // might or might not return a connection
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // establish a connection
  val host = config.get("host")
  val port = config.get("port")
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionStatus = connection.map(c => c.connect)

  println(connectionStatus)
  connectionStatus.foreach(println)

  // for comprehension
  val forConnectionStatus = for {
    host <- config.get("host") // assuming host, port, and connection are != null - do a .connect
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect

}
