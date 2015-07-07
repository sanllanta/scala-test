import spray.revolver.RevolverPlugin._

seq(Revolver.settings: _*)

releaseSettings

organization := "co.s4n"

name := "scala-basic-project"

scalaVersion := "2.11.6"

publishTo := {
  val nexus = "http://nexus.seven4n.com/content/repositories/s4n-capacitaciones/"
  Some("Nexus Releases" at nexus + "sv")
}

credentials += Credentials("Sonatype Nexus Repository Manager", "nexus.seven4n.com", "s4n-capacitaciones", "capacitaciones")