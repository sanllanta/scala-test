import spray.revolver.RevolverPlugin._

seq(Revolver.settings: _*)

releaseSettings

scalariformSettings

organization := "co.s4n"

name := "scala-base-project"

scalaVersion := "2.11.6"

resolvers ++= Seq(
  "Sonatype releases" at "http://oss.sonatype.org/content/repositories/releases",
  "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Spray repository" at "http://repo.spray.io/"
)

libraryDependencies ++= Seq(
  "com.chuusai"                 %%  "shapeless"                 % "2.1.0" withSources() withJavadoc(),
  "com.typesafe.scala-logging"  %%  "scala-logging"             % "3.1.0" withSources() withJavadoc(),
  "io.spray"                    %%  "spray-can"                 % "1.3.3" withSources() withJavadoc(),
  "io.spray"                    %%  "spray-routing"             % "1.3.3" withSources() withJavadoc(),
  "org.json4s"                  %%  "json4s-ext"                % "3.2.11" withSources() withJavadoc(),
  "org.json4s"                  %%  "json4s-jackson"            % "3.2.11" withSources() withJavadoc(),
  "org.json4s"                  %%  "json4s-native"             % "3.2.11" withSources() withJavadoc(),
  "org.scalaz"                  %%  "scalaz-core"               % "7.1.1" withSources() withJavadoc(),
  "net.ceedubs"                 %%  "ficus"                     % "1.1.2" withSources() withJavadoc(),
  "io.spray"                    %%  "spray-testkit"             % "1.3.3" % "test",
  "org.scalatest"               %   "scalatest_2.11"            % "2.2.4" % "test"
)

scalacOptions ++= Seq(
  "-deprecation",           
  "-encoding", "UTF-8",
  "-feature",                
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xfatal-warnings",       
  "-Xlint",
  "-Yno-adapted-args",       
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",   
  "-Ywarn-value-discard",
  "-Xfuture",
  "-Xcheckinit"
)

publishMavenStyle := true

pomIncludeRepository := { _ => false }

publishArtifact in Test := false

publishTo := {
  val nexus = "http://somewhere/nexus/"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("Nexus Snapshots" at nexus + "content/repositories/snapshots/")    
  else
    Some("Nexus Releases" at nexus + "content/repositories/releases")
}

credentials += Credentials("Sonatype Nexus Repository Manager", "somewhere", "user", "password")
