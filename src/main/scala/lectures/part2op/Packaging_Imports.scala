package lectures.part2op // <<-- not an expression; identifies a package

object Packaging_Imports extends App {

  // packages are accessible by their simple name:
  val writer = new Writer("Daniel", "Rock the JVM", 2018)

  // import the package
  //by the keyword import <package name>
  // packages are in hierarchy and matching folder structure

  // package objects
  // can create in IDEA directly
  // can access the methods from the package obj directly
  // rarely used in practice

  //imports
  // imports are grouped together
  // OR import packageName._ <- everything
  // aliasing with => arrow

  // default imports:
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???


}
