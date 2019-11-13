ThisBuild / name := "examples-scala"
ThisBuild / organization := "com.epam.reportportal"
ThisBuild / scalaVersion := "2.11.12"
ThisBuild / licenses := Seq("Apache-2.0" -> url("https://opensource.org/licenses/Apache-2.0"))

lazy val dependencies =
  new {
    val scalatestVersion = "3.0.8"
    val scalaAgentVersion = "5.0.1"
    val loggerLogbackVersion = "5.0.0-BETA-4"
    val logbackVersion = "1.2.3"
    val slf4jVersion = "1.7.25"

    val scalatest = "org.scalatest" %% "scalatest" % scalatestVersion % "test"
    val scalaAgent = "com.epam.reportportal" %% "agent-scala-scalatest" % scalaAgentVersion % "test"
    val loggerLogback = "com.epam.reportportal" % "logger-java-logback" % loggerLogbackVersion % "test"
    val logback = "ch.qos.logback" % "logback-classic" % logbackVersion % "test"
    val slf4j = "org.slf4j" % "jul-to-slf4j" % slf4jVersion % "test"
  }

lazy val commonDependencies = Seq(
  dependencies.scalaAgent,
  dependencies.loggerLogback,
  dependencies.logback,
  dependencies.slf4j
)

lazy val javaCompilerOptions = Seq("-source", "1.8", "-target", "1.8", "-Xlint")
lazy val commonResolvers = Seq(
  Resolver.jcenterRepo,
  "EPAM bintray" at "https://dl.bintray.com/epam/reportportal"
)

lazy val commonSettings = Seq(
  javacOptions ++= javaCompilerOptions,
  resolvers ++= commonResolvers,
  testOptions ++= Seq(
    Tests.Argument(TestFrameworks.ScalaTest, "-C", "com.epam.reportportal.scalatest.RPReporter")
  ),
  parallelExecution := false,
  logBuffered := false
)

lazy val exampleScalatest = (project in file("example-scalatest"))
  .settings(
    name := "example-scalatest",
    commonSettings,
    libraryDependencies ++= commonDependencies ++ Seq(dependencies.scalatest)
  )

lazy val exampleCucumber = (project in file("example-cucumber"))
  .settings(
    name := "example-cucumber",
    commonSettings,
    libraryDependencies ++= commonDependencies ++ Seq(dependencies.scalatest)
  )

lazy val examplesScala = project
  .in(file("."))
  .settings(
    name := "examples-scala",
    commonSettings
  )
  .aggregate(
    exampleScalatest,
    exampleCucumber
  )