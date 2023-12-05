
// The simplest possible sbt build file is just one line:

scalaVersion := "2.13.8"
// That is, to create a valid sbt build, all you've got to do is define the
// version of Scala you'd like your project to use.

// ============================================================================

// Lines like the above defining `scalaVersion` are called "settings". Settings
// are key/value pairs. In the case of `scalaVersion`, the key is "scalaVersion"
// and the value is "2.13.8"

// It's possible to define many kinds of settings, such as:

name := "skillonomy"
organization := "ch.epfl.scala"
version := "1.0"

libraryDependencies += "com.github.alexdupre" %% "consoleio" % "1.0.4"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1"
libraryDependencies += "org.scala-lang" % "scala-library" % "2.13.8"
