name := "examples-scala"

organization := "com.epam.reportportal"

scalaVersion := "2.11.12"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

licenses += "Apache-2.0" -> url("https://opensource.org/licenses/Apache-2.0")

resolvers ++= Seq(
  Resolver.jcenterRepo,
  "EPAM bintray" at "https://dl.bintray.com/epam/reportportal"
)

libraryDependencies ++= Seq("com.epam.reportportal" %% "agent-scala-scalatest" % "5.0.1" % "test",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "com.epam.reportportal" % "logger-java-logback" % "5.0.0-BETA-4" % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "test",
  "org.slf4j" % "jul-to-slf4j" % "1.7.25" % "test"
)

testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-C", "com.epam.reportportal.scalatest.RPReporter")
)

parallelExecution in Test := false

logBuffered in Test := false
