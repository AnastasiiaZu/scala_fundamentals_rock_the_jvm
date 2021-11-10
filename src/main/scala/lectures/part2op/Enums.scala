/*
package lectures.part2op

object Enums extends App {

  // enum is a data type like a class
  //------>>>> SCALA 3 only <<<<--------

  enum Permissions() {
    case READ, WRITE, EXECUTE, NONE

    //add fields or methods
    def openDocument(): Unit =
      if(this == READ) println("opening document...")
      else println("reading not allowed")
  }

  val somePermissions: Permissions = Permissions.READ

  //constructor args
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4) //100
    case WRITE extends PermissionsWithBits(2) // 010
    case EXECUTE extends PermissionsWithBits(1) //001
    case NONE extends PermissionsWithBits(0) //000
  }

  //companion object serves as a factory methods source
  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits = //whatever
     PermissionsWithBits.NONE
  }

  //standard API
  val somePermissionsOrdinal = somePermissions.ordinal // gives 0
  val allPermissions = PermissionsWithBits.values
  val readPermission: Permissions = Permissions.valueOf("READ") // Permissions.READ

}
*/
